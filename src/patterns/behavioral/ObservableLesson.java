package patterns.behavioral;

import java.util.ArrayList;
import java.util.List;

public class ObservableLesson {
    public static void main(String[] args) {
        Subject subject = new Subject();
        ConcreteObserver concreteObserver = new ConcreteObserver(subject, "one");
        ConcreteObserver concreteObserver2 = new ConcreteObserver(subject, "two");
        concreteObserver.setState("state 1");
        concreteObserver2.setState("state 2");
    }
}

interface Observer {
    void update();
}
class ConcreteObserver implements Observer {
    Subject subject;
    String name;
    String state;

    public ConcreteObserver(Subject subject, String name) {
        this.subject = subject;
        this.name = name;
        this.subject.add(this);
    }

    void setState(String state) {
        this.state = state;
        subject.notifyAllObservers();
    }

    @Override
    public void update() {
        System.out.println(name + " has new state " + state);
    }
}

class Subject {
    List<Observer> observers = new ArrayList<>();
    public void add(Observer observer) {
        observers.add(observer);
    }
    public void notifyAllObservers() {
        for(Observer observer : observers) {
            observer.update();
        }
    }
}