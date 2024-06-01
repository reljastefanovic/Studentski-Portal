package StudetnskaPlatforma.Moodle.Service;

import StudetnskaPlatforma.Moodle.Entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import StudetnskaPlatforma.Moodle.Repository.fileRepository;
import StudetnskaPlatforma.Moodle.Entity.File;
import java.io.IOException;
import java.util.List;

@Service
public class FileService {

    @Autowired
    private fileRepository fileRepository;

    public File storeFile(MultipartFile file, Long courseId, String courseName) throws IOException {
        String fileName = file.getOriginalFilename();
        File fileEntity = new File();
        fileEntity.setFileName(fileName);
        fileEntity.setData(file.getBytes());
        fileRepository.saveFile(fileName, file.getBytes(), courseId,courseName); // Call custom SQL query
        return fileEntity;
    }


    public File getFile(Long id) {
        return fileRepository.findById(id).orElseThrow(() -> new RuntimeException("File not found with id " + id));
    }
    public List<File> getAllFiles() {
        return fileRepository.findAll();
    }
    public List<File> getCourseFiled(String courseName) {
        return fileRepository.coursefiles(courseName);
    }
}
