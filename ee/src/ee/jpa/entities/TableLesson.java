package ee.jpa.entities;

import javax.persistence.*;

@Entity
@Table(name = "t_person")
@SecondaryTables({@SecondaryTable(name = "city"),@SecondaryTable(name = "country")})
public class TableLesson {
    @Id @GeneratedValue
    int id;
    String name;
    @Column(table = "city")
    String city;
    @Column(table = "city")
    String zipCode;
    @Column(table = "country")
    String country;

    public TableLesson() {
    }

    public TableLesson(String name, String city, String zipCode, String country) {
        this.name = name;
        this.city = city;
        this.zipCode = zipCode;
        this.country = country;
    }
}
