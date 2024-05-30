package StudetnskaPlatforma.Moodle.Repository;

import StudetnskaPlatforma.Moodle.Entity.Course;

import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface courseRepository extends JpaRepository<Course, Integer> {
    @Query(value = "SELECT c.* FROM courses c JOIN user_courses uc ON c.id = uc.course_id JOIN users u ON uc.username = u.username WHERE u.username = :username", nativeQuery = true)
    List<Course> findCourseNamesByUsername(@Param("username") String username);
    Course findByName(String name);
}