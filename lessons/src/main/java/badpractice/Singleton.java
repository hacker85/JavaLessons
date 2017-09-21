package badpractice;

public class Singleton {
    static Singleton get() {
        return new Singleton();
    }
}
