package ee.jpa.ementity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class VersionBook {
    @Id
    @GeneratedValue
    private int id;
    private String title;
    @Version
    private Integer version;

    public VersionBook() {}

    public VersionBook(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
