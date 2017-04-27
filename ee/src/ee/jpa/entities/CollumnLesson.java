package ee.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CollumnLesson {
    @Id @GeneratedValue
    int id;
    @Column(name = "studentName", length = 50, unique = true, nullable = false, insertable = true, updatable = false)
    String name;
    @Column(columnDefinition = "varchar(255) null")
    String serName;

    public CollumnLesson() {
    }

    public CollumnLesson(String name) {
        this.name = name;
    }
}