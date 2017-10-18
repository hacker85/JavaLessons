package entities;

import org.hibernate.annotations.NaturalId;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Person {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    @ElementCollection
    private List<HomeAddress> homeAddress;
    @ElementCollection
//    @OrderBy("marks")
//    @OrderColumn
//    @org.hibernate.annotations.OrderBy(clause = "marks DESC")
//    @SortComparator(MyComparator.class)
    private List<Integer> marks;

    @NaturalId
    private String iCode;

//    @ElementCollection
//    @CollectionTable(name = "PersonMap")
//    @Column(name = "name")
//    @MapKeyColumn(name = "'key'")
//    private Map<String,String> map;

    public Person() {}
    public Person(String name, List<HomeAddress> homeAddress) {
        this.name = name;
        this.homeAddress = homeAddress;
    }

    public Person(String name, List<HomeAddress> homeAddress, List<Integer> marks) {
        this.name = name;
        this.homeAddress = homeAddress;
        this.marks = marks;
    }

    public Person(String name, List<HomeAddress> homeAddress, List<Integer> marks, String iCode) {
        this.name = name;
        this.homeAddress = homeAddress;
        this.marks = marks;
        this.iCode = iCode;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", homeAddress=" + homeAddress +
                ", marks=" + marks +
                ", iCode='" + iCode + '\'' +
                '}';
    }
}
