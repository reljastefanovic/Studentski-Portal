package StudetnskaPlatforma.Moodle.Service;

import StudetnskaPlatforma.Moodle.Entity.Course;
import StudetnskaPlatforma.Moodle.Entity.Users;
import StudetnskaPlatforma.Moodle.Entity.Video;
import StudetnskaPlatforma.Moodle.Repository.enrolledRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import StudetnskaPlatforma.Moodle.Repository.courseRepository;
import StudetnskaPlatforma.Moodle.Repository.videoRepository;
import java.util.List;

@Service
public class CourseService {
    @Autowired
    private courseRepository repo;
    @Autowired
    private enrolledRepository enrolledRepository;
    @Autowired
    private videoRepository videoRepository;

    public List<Course> getAllCourses() {
        return repo.findAll();
    }

    public String getLoggedInUserDetails() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        } else {
            return principal.toString();
        }
    }

    public List<Course> getCourseNamesForLoggedInUser() {
        String username = getLoggedInUserDetails();
        return repo.findCourseNamesByUsername(username);
    }
    public String getUsername() {
        String username = getLoggedInUserDetails();
        return username;
    }

    public void enrollUserToCourse(Long courseId) {
        String username = getUsername();
        enrolledRepository.enrollUserToCourse(username, courseId); // Prosleđivanje korisničkog imena i ID kursa
    }
    public void leaveCourse(Long courseId) {
        String username = getUsername();
        enrolledRepository.leaveCourse(courseId,username);
    }



    public Course findByName(String name) {
        return repo.findByName(name);
    }
    public List<String> findStudentsByCourseName(String courseName) {
        return repo.findStudentsByCourseName(courseName);
    }
    public void visitinsert(String courseName) {

        repo.InsertVisits(courseName);
    }
    public void saveVideo(String videoName, String videoUrl, Long courseId, String courseName) {
        videoRepository.saveVideo(videoName, videoUrl, courseId, courseName);
    }

    public List<Video> courseVideos(String courseName) {
        return videoRepository.courseVideos(courseName);
    }
    public void deleteVideo(Long id) {
        videoRepository.deleteVideo(id);
    }

}