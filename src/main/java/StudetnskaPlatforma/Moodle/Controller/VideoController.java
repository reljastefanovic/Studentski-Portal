package StudetnskaPlatforma.Moodle.Controller;

import StudetnskaPlatforma.Moodle.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
public class VideoController {
    @Autowired
    private CourseService courseService;
    @PostMapping("/uploadVideo/{courseName}")
    public String uploadVideo(  @RequestParam("video_name") String video_name,
                              @RequestParam("video_url") String video_url,
                              @RequestParam("courseId") Long courseId,
                              @PathVariable("courseName") String courseName) {

        courseService.saveVideo(video_name, video_url, courseId, courseName);

        return "redirect:/courses/{courseName}";
    }
    @PostMapping("/deletevideo/{courseName}")
    public String deletevideo(@RequestParam("id") Long id,@PathVariable("courseName") String courseName) {
        courseService.deleteVideo(id);
        return "redirect:/courses/{courseName}";
    }
}
