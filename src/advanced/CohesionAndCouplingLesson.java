package advanced;

public class CohesionAndCouplingLesson {
    public static void main(String[] args) {

    }
}

class A {
    private int i;
    public int getI() {
        return i;
    }
}

class B {
    void printI() {
        System.out.println(new A().getI());
    }
}

class Zakkusachnaya {
    Cook cook;
    Weiter weiter;
    Janitor janitor;
}

class Cook {
    void cook() {

    }
}
class Weiter {
    void deliverFood() {

    }
}
class Janitor {
    void cleanFloor() {

    }
}
