package StudetnskaPlatforma.Moodle.Controller;

import StudetnskaPlatforma.Moodle.Entity.Course;
import StudetnskaPlatforma.Moodle.Entity.File;
import StudetnskaPlatforma.Moodle.Service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import StudetnskaPlatforma.Moodle.Repository.fileRepository;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
public class FileController {

    @Autowired
    private FileService fileService;


    @PostMapping("/upload/{courseName}")
    public String uploadFile(@RequestParam("file") MultipartFile file,@RequestParam("courseId") Long courseId,@PathVariable String courseName) {
        try {
            File fileEntity = fileService.storeFile(file,courseId,courseName);
            return "redirect:/courses/{courseName}";
        } catch (IOException e) {
            return "GreŠka";
        }
    }
    @GetMapping("/file/{id}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable Long id) {
        File fileEntity = fileService.getFile(id);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileEntity.getFileName() + "\"")
                .body(fileEntity.getData());
    }
    @PostMapping("/deletefile/{courseName}")
    public String deleteFile(@RequestParam("id") Long id,@PathVariable("courseName") String courseName) {
        fileService.deleteFile(id);
        return "redirect:/courses/{courseName}";
    }


}
