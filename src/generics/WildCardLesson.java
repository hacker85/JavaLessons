package generics;

public class WildCardLesson {
    public static void main(String[] args) {
//        Gen2<Car> car = new Gen2<Toyota>();
        Gen2<?> car = new Gen2<Toyota>();
        Toyota t = (Toyota)car.getT();
//        car.setT(new Toyota());
//        car.setT(new Car());
        Gen2<? extends Car> car2 = new Gen2<Car>();
        Gen2<? extends Car> car3 = new Gen2<Car>();
        Gen2<? extends Toyota> car4 = new Gen2<Toyota>();
        Car c = car2.getT();
        Car t2 = car4.getT();
        Toyota t3 = car4.getT();
        Object to = car4.getT();
        //Corolla t4 = car4.getT();
//        car2.setT(new Car());
//        car2.setT(new Toyota());
        printCar(car4);

        Gen2<? super Car> supCar = new Gen2<>();
        supCar.setT(new Car());
        supCar.setT(new Toyota());
//        supCar.setT(new Object());
        Gen2<? extends Car> myCar = (Gen2<? extends Car>) supCar;
        Car cr = myCar.getT();
        System.out.println(cr);

    }
    static void printCar(Gen2<? extends Car> c) {
        System.out.println(c.getT());
    }
}

class Car{}
class Toyota extends Car {}
class Corolla extends Toyota {}
class Audi extends Car {}

class Gen2<T> {
    T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}