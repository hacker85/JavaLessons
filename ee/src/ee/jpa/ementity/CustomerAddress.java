package ee.jpa.ementity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CustomerAddress {
    @Id @GeneratedValue
    int id;
    String street;
    String city;

    public CustomerAddress() {
    }

    public CustomerAddress(String street, String city) {
        this.street = street;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
