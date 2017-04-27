package ee.jpa.entities;

import javax.persistence.*;

@Entity
@Access(AccessType.FIELD)
public class AccessTypeLesson {
    @Id @GeneratedValue
    int id;
    @Transient
    String name;


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Access(AccessType.PROPERTY)
    public String getName() {
        return "Mr. " + name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
