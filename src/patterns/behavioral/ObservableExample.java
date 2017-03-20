package patterns.behavioral;

import java.util.ArrayList;
import java.util.List;

public class ObservableExample {
    public static void main(String[] args) {
        MyObserver concreteMyObserver = new MyObserver( "one");
        MyObserver concreteMyObserver2 = new MyObserver("two");
        concreteMyObserver.setState("state 1");
        concreteMyObserver2.setState("state 2");
    }
}
class MyObserver {
    String name;
    String state;
    static List<MyObserver> myObservers = new ArrayList<>();

    public MyObserver(String name) {
        this.name = name;
        myObservers.add(this);
    }

    void setState(String state) {
        this.state = state;
        notifyAllObservers();
    }

    public void notifyAllObservers() {
        for(MyObserver myObserver : myObservers) {
            myObserver.update();
        }
    }

    public void update() {
        System.out.println(name + " has new state " + state);
    }
}