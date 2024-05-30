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
    @Autowired
    private fileRepository fileRepository;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            File fileEntity = fileService.storeFile(file);
            return ResponseEntity.status(HttpStatus.OK).body("File uploaded successfully: " + fileEntity.getFileName());
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Could not upload the file: " + e.getMessage());
        }
    }
    @GetMapping("/asd")
    public String upload()
    {
        return "upload";
    }
    @GetMapping("/dsa")
    public String getAllFiles(Model model) {
        List<File> files = fileService.getAllFiles();
        model.addAttribute("files", files);
        return "testupload";
    }
    @GetMapping("/file/{id}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable Long id) {
        File fileEntity = fileService.getFile(id);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(fileEntity.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileEntity.getFileName() + "\"")
                .body(fileEntity.getData());
    }


}
