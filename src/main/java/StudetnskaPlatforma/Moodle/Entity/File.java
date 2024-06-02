package StudetnskaPlatforma.Moodle.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "courses_data")
public class File {
    @Id
    @Column(name = "id")
    private Long id ;
    @Column(name = "course_id")
    private Long course_id;

    @Column(name = "file_name", nullable = false)
    private String fileName;
    @Column(name = "course_name", nullable = false)
    private String courseName;

    @Lob
    @Column(name = "file_data")
    private byte[] data;

    public File(Long id, Long course_id, String fileName, String courseName, byte[] data) {
        this.id = id;
        this.course_id = course_id;
        this.fileName = fileName;
        this.courseName = courseName;
        this.data = data;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public File(Long course_id, String fileName, String courseName, byte[] data) {
        this.course_id = course_id;
        this.fileName = fileName;
        this.courseName = courseName;
        this.data = data;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }



    public String getFileName() {
        return fileName;
    }


    public byte[] getData() {
        return data;
    }



    public Long getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Long course_id) {
        this.course_id = course_id;
    }

    public Long getId() {
        return id;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public File() {
    }
}
