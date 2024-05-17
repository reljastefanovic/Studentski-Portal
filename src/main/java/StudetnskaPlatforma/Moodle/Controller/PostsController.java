package StudetnskaPlatforma.Moodle.Controller;

import StudetnskaPlatforma.Moodle.Entity.Course;
import StudetnskaPlatforma.Moodle.Entity.Posts;
import StudetnskaPlatforma.Moodle.Repository.postsRepository;
import StudetnskaPlatforma.Moodle.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Controller
public class PostsController {
    @Autowired
    postsRepository repo;
    @Autowired
    CourseService courseService;

    @GetMapping("/")
    public String getposts(Model model) {
        List<Posts> posts = repo.findLastFourPosts();
        model.addAttribute("posts", posts);


        List<Course> courses = courseService.getCourseNamesForLoggedInUser();
        model.addAttribute("courses", courses);
        return "index"; // This will resolve to courses.htm
    }
    @PostMapping("/post")
    public String postposts(  @RequestParam("title") String title,
                              @RequestParam("tekst") String tekst,
                              @RequestParam("url") String url) {
        repo.savePost(title,tekst,url);
        return "redirect:";}
}