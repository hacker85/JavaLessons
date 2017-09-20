package bestpractice;

import java.math.BigInteger;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class StaticFactory {
    //advantages:
    //1. name
    //2. cache
    //3. inheritance
    //disadvantages
    //1. cant subclass if all constructors private
    //2. not intuitive
    public static void main(String[] args) throws SQLException {
        //examples
        BigInteger bigInteger1 = new BigInteger(1, 2, new Random());
        BigInteger bigInteger2 = BigInteger.probablePrime(1, new Random());
        DriverManager.getConnection("");

        Car.getSportCar();
    }
}

class Car {
    String color;
    int doors;
    private static Map<String,Car> cache = new HashMap<>();
    private Car(String color) {
        this.color = color;
    }
    private Car(int doors) {
        this.doors = doors;
    }
    Car() {

    }
    public static Car getWhiteCar(String color) {
        if(cache.containsValue(color)) {
            return cache.get(color);
        }
        return cache.put(color, new Car(color));
    }
    public static Car getSportCar() {
        return new Car(2);
    }
    public static Car getFerary() {
        return new Ferary();
    }
}
class Ferary extends Car {

}
