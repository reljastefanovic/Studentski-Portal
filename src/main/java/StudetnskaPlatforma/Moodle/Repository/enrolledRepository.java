package StudetnskaPlatforma.Moodle.Repository;

import StudetnskaPlatforma.Moodle.Entity.Course;
import StudetnskaPlatforma.Moodle.Entity.Enrolled;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface enrolledRepository extends JpaRepository<Enrolled, String> {
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO user_courses (username, course_id) VALUES (:username, :courseId)", nativeQuery = true)
    void enrollUserToCourse(@Param("username") String username, @Param("courseId") Long courseId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM user_courses WHERE course_id = :courseId AND username = :username", nativeQuery = true)
    void leaveCourse(@Param("courseId") Long courseId, @Param("username") String username);




}

