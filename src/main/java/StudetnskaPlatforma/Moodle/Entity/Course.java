package StudetnskaPlatforma.Moodle.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Table(name="courses")
@Entity
public class Course {
    @Id
    private String id;
    private String name;
    private String  subject_url;
    private String image_url;

    private int visits;

    public int getVisits() {
        return visits;
    }

    public void setVisits(int visits) {
        this.visits = visits;
    }

    public Course(String id, String name, String subject_url, String image_url, int visits) {
        this.id = id;
        this.name = name;
        this.subject_url = subject_url;
        this.image_url = image_url;
        this.visits = visits;
    }

    public Course()
    {

    }
    public String getSubject_url() {
        return subject_url;
    }

    public void setSubject_url(String subject_url) {
        this.subject_url = subject_url;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}