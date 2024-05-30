package StudetnskaPlatforma.Moodle.Repository;

import StudetnskaPlatforma.Moodle.Entity.File;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.xml.crypto.Data;

public interface fileRepository extends JpaRepository<File, Long> {
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO file_entity (file_name, file_type, data) VALUES (?1, ?2, ?3)", nativeQuery = true)
    void savePost(String filename, String filetype, byte[] data);
}
