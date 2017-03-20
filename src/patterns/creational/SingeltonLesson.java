package patterns.creational;

public class SingeltonLesson {
    public static void main(String[] args) {
        Singelton singelton = Singelton.getInstance();
    }
}

class Singelton {
    static Singelton singelton = new Singelton();
    private Singelton() {

    }
    public static Singelton getInstance() {
        return singelton;
    }
}
