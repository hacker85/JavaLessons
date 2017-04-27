package ee.jpa.entities;

import javax.persistence.*;

@Entity
public class OneToOneLesson {
    @Id @GeneratedValue
    int id;
    String name;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "homeAddress")
    HomeAddress homeAddress;

    public OneToOneLesson() {
        name = "oneToOne";
        homeAddress = new HomeAddress();
        homeAddress.city = "myCity";
        homeAddress.street = "myStreet";
        homeAddress.oneToOneLesson = this;
    }
}
@Entity
class HomeAddress {
    @Id @GeneratedValue
    int id;
    String city;
    String street;
    @OneToOne(mappedBy = "homeAddress")
    OneToOneLesson oneToOneLesson;
}
