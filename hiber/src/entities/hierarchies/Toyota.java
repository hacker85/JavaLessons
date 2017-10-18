package entities.hierarchies;

import javax.persistence.Entity;

@Entity
public class Toyota extends Car {
    private String maxSpeed;

    public Toyota(String number, String maxSpeed) {
        super(number);
        this.maxSpeed = maxSpeed;
    }
}
