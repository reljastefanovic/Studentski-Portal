package StudetnskaPlatforma.Moodle.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;

@Table(name="user_courses")
@Entity
public class Enrolled {
    @Id
    private String username;
    private Long course_id;

    public void setUsername(String username) {
        this.username = username;
    }

    public Enrolled() {
    }

    public Enrolled(String username, Long course_id) {
        this.username = username;
        this.course_id = course_id;
    }

    public void setCourse_id(Long course_id) {
        this.course_id = course_id;
    }

    public String getUsername() {
        return username;
    }

    public Long getCourse_id() {
        return course_id;
    }
}
