package StudetnskaPlatforma.Moodle.Controller;

import StudetnskaPlatforma.Moodle.Entity.Course;
import StudetnskaPlatforma.Moodle.Entity.File;
import StudetnskaPlatforma.Moodle.Entity.Users;
import StudetnskaPlatforma.Moodle.Entity.Video;
import StudetnskaPlatforma.Moodle.Service.CourseService;
import StudetnskaPlatforma.Moodle.Service.FileService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;
    @Autowired
    private FileService fileService;

    @GetMapping("/statistika")
    public String Statistika(Model model) {
        List<Course> courses = courseService.getAllCourses();
        model.addAttribute("courses", courses);
        return "statistika"; // This will resolve to courses.html
    }
    @PostMapping("/enroll/{courseName}")
    public String enrollUserToCourse(@RequestParam("courseId") Long courseId,@PathVariable("courseName") String courseName) {
        try {
            courseService.enrollUserToCourse(courseId);
            return "redirect:/courses/{courseName}";
        } catch (Exception e) {
            return "redirect:/courses/{courseName}";
        }
    }
    @GetMapping("/courses")
    public String getAllCourses(Model model) {
        List<Course> courses = courseService.getAllCourses();
        model.addAttribute("courses", courses);
        return "courses"; // This will resolve to courses.html
    }
    @PostMapping("/leave/{id}")
    public String leave(@PathVariable("id") Long courseId) {
            courseService.leaveCourse(courseId);
            return "redirect:/";

    }


    @GetMapping("/courses/{courseName}")
    public String getCourseDetails(@PathVariable String courseName, @RequestParam(required = false) String continueUrl, Model model) {
        // Retrieve the course details
        Course course = courseService.findByName(courseName);
        model.addAttribute("course", course);


        List<Course> courses = courseService.getCourseNamesForLoggedInUser();
        model.addAttribute("courses", courses);


        System.out.println("Value of courseName: " + courseName);
        courseService.visitinsert(courseName);


        List<String> students = courseService.findStudentsByCourseName(courseName);
        model.addAttribute("students", students);


        List<File> files = fileService.getCourseFiled(courseName);
        model.addAttribute("files", files);

        List<Video> videos = courseService.courseVideos(courseName);
        model.addAttribute("videos",videos);


        return "testorino";
    }



}