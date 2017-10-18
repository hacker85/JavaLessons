package entities;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
//@Access(AccessType.FIELD)
public class Address implements Serializable {

    public Address() {}

    public Address(String street, int number) {
        this.street = street;
        this.number = number;
    }

    String street;
    int number;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (number != address.number) return false;
        return street != null ? street.equals(address.street) : address.street == null;
    }

    @Override
    public int hashCode() {
        int result = street != null ? street.hashCode() : 0;
        result = 31 * result + number;
        return result;
    }
}
