package StudetnskaPlatforma.Moodle.Controller;

import StudetnskaPlatforma.Moodle.Entity.Course;
import StudetnskaPlatforma.Moodle.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import java.util.Optional;

@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/courses")
    public String getAllCourses(Model model) {
        List<Course> courses = courseService.getAllCourses();
        model.addAttribute("courses", courses);
        return "courses"; // This will resolve to courses.html
    }

    @GetMapping("/courses/{name}")
    public String getCourseByName(@PathVariable String name, Model model) {
        // Construct the template name from the course name
        String templateName = name.toLowerCase(); // Assuming your HTML files are all lowercase
        model.addAttribute("courseName", name);
        return templateName; // This will resolve to the corresponding HTML template
    }
}