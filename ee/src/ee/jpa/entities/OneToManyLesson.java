package ee.jpa.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class OneToManyLesson {
    @Id @GeneratedValue
    int id;
    String name;
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "oneId")
//    @JoinTable(name = "joinTable", joinColumns = @JoinColumn(name = "oneId"), inverseJoinColumns = @JoinColumn(name = "addredId"))
    List<WorkAddress> list;

    public OneToManyLesson() {
        list = new ArrayList<>();
        list.add(new WorkAddress(this));
        list.add(new WorkAddress(this));
    }
}

@Entity
class WorkAddress {
    @Id @GeneratedValue
    int id;
    String city;
    String street;
//    @ManyToOne
    OneToManyLesson oneToManyLesson;

    public WorkAddress() {
        city = "myCity";
        street = "myStreet";
    }

    public WorkAddress(OneToManyLesson oneToManyLesson) {
        this.oneToManyLesson = oneToManyLesson;
        city = "myCity";
        street = "myStreet";
    }
}
