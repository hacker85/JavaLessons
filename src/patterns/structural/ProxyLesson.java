package patterns.structural;

public class ProxyLesson {
    public static void main(String[] args) {
        CarI car = new CarProxy();
        car.drive();
    }
}

interface CarI {
    void drive();
}

class CarProxy implements CarI {
    CarI car = new Reno();

    @Override
    public void drive() {
        System.out.println("proxy code");
        car.drive();
    }
}

class Reno implements CarI {
    @Override
    public void drive() {
        System.out.println("drive reno");
    }
}