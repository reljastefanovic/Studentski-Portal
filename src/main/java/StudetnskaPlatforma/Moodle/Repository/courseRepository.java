package StudetnskaPlatforma.Moodle.Repository;

import StudetnskaPlatforma.Moodle.Entity.Course;

import StudetnskaPlatforma.Moodle.Entity.Users;
import jakarta.persistence.Id;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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
    @Query(value = "SELECT u.username FROM users u JOIN user_courses uc ON u.username = uc.username JOIN courses c ON uc.course_id = c.id WHERE c.name = :courseName", nativeQuery = true)
    List<String> findStudentsByCourseName(@Param("courseName") String courseName);
    @Modifying
    @Transactional
    @Query(value="UPDATE courses SET visits =visits+1 WHERE name = :coursename", nativeQuery=true)
    void InsertVisits(@Param("coursename") String coursename);

}
