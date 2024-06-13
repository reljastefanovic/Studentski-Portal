package StudetnskaPlatforma.Moodle.Repository;

import StudetnskaPlatforma.Moodle.Entity.File;
import StudetnskaPlatforma.Moodle.Entity.Users;
import StudetnskaPlatforma.Moodle.Entity.Video;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface videoRepository extends JpaRepository<Video,Long> {
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO video_course_data (video_name, video_url, course_id,course_name) VALUES (:video_name, :video_url, :courseId, :courseName)", nativeQuery = true)
    void saveVideo(@Param("video_name") String video_name, @Param("video_url") String video_url, @Param("courseId") Long courseId, @Param("courseName") String courseName);
    @Query(value = "select * from video_course_data where course_name=:course_name", nativeQuery = true)
    List<Video> courseVideos(@Param("course_name") String course_name);
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM video_course_data WHERE id=?1", nativeQuery = true)
    void deleteVideo(Long id);

}
