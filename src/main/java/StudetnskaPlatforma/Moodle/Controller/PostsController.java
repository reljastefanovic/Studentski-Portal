package StudetnskaPlatforma.Moodle.Controller;

import StudetnskaPlatforma.Moodle.Entity.Course;
import StudetnskaPlatforma.Moodle.Entity.Posts;
import StudetnskaPlatforma.Moodle.Repository.postsRepository;
import StudetnskaPlatforma.Moodle.Service.CourseService;
import StudetnskaPlatforma.Moodle.Service.LoggedInUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Controller
public class PostsController {
    @Autowired
    postsRepository repo;
    @Autowired
    CourseService courseService;
    @Autowired
    LoggedInUserService loggedInUserService;

    @GetMapping("/")
    public String getposts(Model model) {
        List<Posts> posts = repo.findLastFourPosts();
        model.addAttribute("posts", posts);
        List<String> loggedInUsers = loggedInUserService.getAllLoggedInUsers();
        model.addAttribute("loggedInUsers", loggedInUsers);

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
    @PostMapping("/edit/{postid}")
    public String editpost(  @PathVariable int postid,
                             @RequestParam("title") String title,
                             @RequestParam("tekst") String tekst,
                             @RequestParam("url") String url) {
        repo.editPost(title,tekst,url,postid);
        return "redirect:/";
    }
    @PostMapping("/deletepost/{postid}")
    public String deletepost(@PathVariable int postid)
    { repo.deletePost(postid);
        return "redirect:/";
    }
}