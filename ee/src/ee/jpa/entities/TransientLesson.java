package ee.jpa.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TransientLesson {
    @Id @GeneratedValue
    int id;
    String name;
//    @Transient
    transient
    int age;

    public TransientLesson() {
    }

    public TransientLesson(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
