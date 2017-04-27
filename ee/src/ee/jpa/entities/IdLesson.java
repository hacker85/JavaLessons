package ee.jpa.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class IdLesson {
    @Id
    int id;
    String name;

    public IdLesson() {
    }

    public IdLesson(String name) {
        this.name = name;
    }
}
