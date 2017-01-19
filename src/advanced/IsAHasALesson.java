package advanced;

public class IsAHasALesson {
    public static void main(String[] args) {
        MyCar myCar = new MyCar();
        myCar.listen();

    }
}

class Telega {
    int weels = 4;
}
class MyCar {
    Radio radio = new Radio();
    void listen() {
        radio.listen();
    }
    void drive() {

    }
}
class Radio {
    void listen() {
        System.out.println("listen radio");
    }
}