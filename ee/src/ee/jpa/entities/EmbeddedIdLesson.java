package ee.jpa.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(MyId.class)
public class EmbeddedIdLesson {
//    @EmbeddedId
//    private MyId id;
    @Id
    String name;
    @Id
    String serName;
    int age;

    public EmbeddedIdLesson() {
    }

    public EmbeddedIdLesson(String name, String serName, int age) {
//        this.id = new MyId(name, serName);
        this.name = name;
        this.serName = serName;
        this.age = age;
    }
}
//@Embeddable
class MyId implements Serializable {
    String name;
    String serName;

    public MyId() {
    }

    public MyId(String name, String serName) {
        this.name = name;
        this.serName = serName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSerName() {
        return serName;
    }

    public void setSerName(String serName) {
        this.serName = serName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyId myId = (MyId) o;

        if (name != null ? !name.equals(myId.name) : myId.name != null) return false;
        return serName != null ? serName.equals(myId.serName) : myId.serName == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (serName != null ? serName.hashCode() : 0);
        return result;
    }
}
