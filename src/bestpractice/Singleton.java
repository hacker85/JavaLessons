package bestpractice;

import java.io.Serializable;

public class Singleton implements Serializable {

    enum MySingleton {
        INSTANCE;
        public void doJob() {

        }
    }

    private static final Singleton singleton = new Singleton();

    private Singleton() {}

    public static Singleton getInstance() {
        return singleton;
    }

    private Object readResolve()  {
        return singleton;
    }

    //approaches
    //advantages
    //serializable
    //enum
    public static void main(String[] args) {
//        singleton.someMethod();
//        someOterhLocalMethod();
        Singleton.getInstance();
    }
}
