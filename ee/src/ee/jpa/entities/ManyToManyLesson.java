package ee.jpa.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ManyToManyLesson {
    @Id @GeneratedValue
    int id;
    String name;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "joinLecion", joinColumns = @JoinColumn(name = "mainId"), inverseJoinColumns = @JoinColumn(name = "lectionId"))
    List<Lection> lections;

    public ManyToManyLesson() {
        name = "SomeName";
        lections = new ArrayList<>();
        lections.add(new Lection(this));
    }
}
@Entity
class Lection {
    @Id @GeneratedValue
    int id;
    String name;
    @ManyToMany(mappedBy = "lections")
    List<ManyToManyLesson> list;

    public Lection(ManyToManyLesson manyToManyLesson) {
        list = new ArrayList<>();
        list.add(manyToManyLesson);
    }
}