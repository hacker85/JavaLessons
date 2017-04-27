package ee.jpa.ementity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Customer {
    @Id @GeneratedValue
    int id;
    String name;
    @OneToOne(orphanRemoval = true)
    CustomerAddress customerAddress;

    public Customer() {
    }

    public Customer(String name, CustomerAddress customerAddress) {
        this.name = name;
        this.customerAddress = customerAddress;
    }
}
