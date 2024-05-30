package StudetnskaPlatforma.Moodle.Repository;

import StudetnskaPlatforma.Moodle.Entity.File;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.xml.crypto.Data;

public interface fileRepository extends JpaRepository<File, Long> {
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO courses_data (file_name, file_data, course_id) VALUES (:fileName, :data, :courseId)", nativeQuery = true)
    void saveFile(@Param("fileName") String fileName, @Param("data") byte[] data, @Param("courseId") Long courseId);
}
