package ee.jpa.entities;

import javax.persistence.*;

@Entity
public class EbeddableLesson {
    @Id @GeneratedValue
    int id;
    String name;
    @Embedded
    Address address;

    public EbeddableLesson() {
        name = "Max";
        address = new Address();
        address.street = "MyStreet";
        address.city = "MyCity";
    }
}

@Embeddable
class Address {
    String street;
    String city;
    String zipCode;
}
