package patterns.creational;

public class FactoryLesson {
    public static void main(String[] args) {
//        Factory factory = new Factory();
//        Car toyota = factory.create("Toyota");
//        Car audi = factory.create("Audi");
//        toyota.drive();
//        audi.drive();
    }
}

//interface Car {
//    void drive();
//}
//
//class Toyota implements Car {
//    @Override
//    public void drive() {
//        System.out.println("drive Toyota");
//    }
//}
//
//class Audi implements Car {
//    @Override
//    public void drive() {
//        System.out.println("drive Audi");
//    }
//}
//
//class Factory {
//    public Car create(String typeOfCar) {
//        switch (typeOfCar) {
//            case "Toyota" : return new Toyota();
//            case "Audi": return new Audi();
//            default: return null;
//        }
//    }
//}