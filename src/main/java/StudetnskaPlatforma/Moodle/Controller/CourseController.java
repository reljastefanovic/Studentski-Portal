package StudetnskaPlatforma.Moodle.Controller;

import StudetnskaPlatforma.Moodle.Entity.Course;
import StudetnskaPlatforma.Moodle.Entity.File;
import StudetnskaPlatforma.Moodle.Entity.Users;
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

    @GetMapping("/courses")
    public String getAllCourses(Model model) {
        List<Course> courses = courseService.getAllCourses();
        model.addAttribute("courses", courses);
        return "courses"; // This will resolve to courses.html
    }
    @PostMapping("/enroll")
    public ResponseEntity<String> enrollUserToCourse(@RequestParam("courseId") Long courseId) {
        try {
            courseService.enrollUserToCourse(courseId);
            return ResponseEntity.ok("User enrolled successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Could not enroll user: " + e.getMessage());
        }
    }


    @GetMapping("/courses/{courseName}")
    public String getCourseDetails(@PathVariable String courseName, @RequestParam(required = false) String continueUrl, Model model) {
        // Retrieve the course details
        Course course = courseService.findByName(courseName);
        model.addAttribute("course", course);


        List<Course> courses = courseService.getCourseNamesForLoggedInUser();
        model.addAttribute("courses", courses);


        System.out.println("Value of courseName: " + courseName);



            List<String> students = courseService.findStudentsByCourseName(courseName);
            model.addAttribute("students", students);


        // Retrieve all files
        List<File> files = fileService.getAllFiles();
        model.addAttribute("files", files);


        return "testorino";
    }



}