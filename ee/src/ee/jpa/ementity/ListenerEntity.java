package ee.jpa.ementity;

import ee.jpa.advanced.ListenersLesson;

import javax.persistence.*;

@Entity
@EntityListeners({ListenersLesson.class})
@ExcludeDefaultListeners
public class ListenerEntity {
    @Id @GeneratedValue
    int id;
    String name;

    @PrePersist
    void prePersist() {
        System.out.println("inner prePersist");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
