package ee.jpa.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
public class CollectionsLesson {
    @Id @GeneratedValue
    int id;
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "numbers")
    @Column(name = "value")
    List<String> list;

    @ElementCollection
    @CollectionTable
    @Column(name = "title")
    @MapKeyColumn(name = "position")
    Map<Integer,String> map;

    public CollectionsLesson() {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        this.list = list;
        Map<Integer,String> map = new HashMap<>();
        map.put(1, "One");
        map.put(2, "Two");
        this.map = map;
    }
}
