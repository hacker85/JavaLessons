package ee.jpa.entities;

import javax.persistence.*;

@Entity
public class Student {
    @Id @GeneratedValue
    int id;
    String name;

    public Student() {
    }
    public Student(String name) {
        this.name = name;
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