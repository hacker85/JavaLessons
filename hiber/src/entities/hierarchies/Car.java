package entities.hierarchies;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@MappedSuperclass
//@OptimisticLocking(type = OptimisticLockType.VERSION)
//@Cacheable
//@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@NamedQueries(@NamedQuery(name = "getCarByNumber", query = "select c from Car c where c.number = :number"))
public class Car {
    @Id
    @GeneratedValue
    private int id;
    @Fetch(FetchMode.SELECT)
    private String number;
//    @Version
//    int version;

    public Car() {}
    public Car(String number) {
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (id != car.id) return false;
        return number != null ? number.equals(car.number) : car.number == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (number != null ? number.hashCode() : 0);
        return result;
    }
}
