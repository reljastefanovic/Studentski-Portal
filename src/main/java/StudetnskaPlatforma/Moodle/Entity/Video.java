package StudetnskaPlatforma.Moodle.Entity;

import jakarta.persistence.*;
@Entity
@Table(name = "video_course_data")

public class Video {
        @Id
        @Column(name = "id")
        private Long id ;
        @Column(name = "course_id")
        private Long course_id;

        @Column(name = "video_name", nullable = false)
        private String video_name;
        @Column(name = "course_name", nullable = false)
        private String courseName;

        @Column(name = "video_url")
        private String video_url;

    public Video() {
    }

    public Video(Long id, Long course_id, String video_name, String courseName, String video_url) {
        this.id = id;
        this.course_id = course_id;
        this.video_name = video_name;
        this.courseName = courseName;
        this.video_url = video_url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Long course_id) {
        this.course_id = course_id;
    }

    public String getVideo_name() {
        return video_name;
    }

    public void setVideo_name(String video_name) {
        this.video_name = video_name;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getVideo_url() {
        return video_url;
    }

    public void setVideo_url(String video_url) {
        this.video_url = video_url;
    }
}
