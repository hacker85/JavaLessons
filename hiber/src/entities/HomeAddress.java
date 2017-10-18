package entities;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//@Entity
@Embeddable
public class HomeAddress {
//    @Id
//    @GeneratedValue
//    int id;
    String street;

    public HomeAddress() {}
    public HomeAddress(String street) {
        this.street = street;
    }

    public String getStreet() {
        return street;
    }
}
