package StudetnskaPlatforma.Moodle.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name="posts")
@Entity
public class Posts {
    @Id
    private int id;
    private String Title;
    private String url;
    private String tekst;

    public Posts(int id, String title, String url, String texts) {
        this.id = id;
        Title = title;
        this.url = url;
        this.tekst = texts;
    }
    public Posts()
    {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }
}