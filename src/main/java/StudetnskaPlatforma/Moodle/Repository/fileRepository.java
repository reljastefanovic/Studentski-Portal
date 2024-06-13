package StudetnskaPlatforma.Moodle.Repository;

import StudetnskaPlatforma.Moodle.Entity.File;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.xml.crypto.Data;
import java.util.List;

public interface fileRepository extends JpaRepository<File, Long> {
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO courses_data (file_name, file_data, course_id,course_name) VALUES (:fileName, :data, :courseId, :courseName)", nativeQuery = true)
    void saveFile(@Param("fileName") String fileName, @Param("data") byte[] data, @Param("courseId") Long courseId, @Param("courseName") String courseName);

    @Query(value = "INSERT INTO courses_data (file_name, file_data, course_id) VALUES (:fileName, :data, :courseId)", nativeQuery = true)
    void Get(@Param("fileName") String fileName, @Param("data") byte[] data, @Param("courseId") Long courseId);
    @Query(value="SELECT * FROM courses_data WHERE course_name=:course_name", nativeQuery= true)
    List<File> coursefiles(@Param("course_name") String course_name);
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM courses_data WHERE id=?1", nativeQuery = true)
    void deleteFile(Long id);
}
