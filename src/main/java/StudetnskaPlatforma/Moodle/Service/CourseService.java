package StudetnskaPlatforma.Moodle.Service;

import StudetnskaPlatforma.Moodle.Entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import StudetnskaPlatforma.Moodle.Repository.courseRepository;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    private courseRepository repo;

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
    public Course findByName(String name) {
        return repo.findByName(name);
    }

}