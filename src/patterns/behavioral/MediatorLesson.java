package patterns.behavioral;

import java.util.ArrayList;
import java.util.List;

public class MediatorLesson {
    public static void main(String[] args) {
        ConcreteMediator mediator = new ConcreteMediator();
        mediator.add(new ConcreteCollegue(mediator));
        mediator.add(new ConcreteCollegue(mediator));
        Collegue collegue = new ConcreteCollegue(mediator);
        collegue.changeStatus();
    }
}

interface Mediator {
    void requestAll(Collegue collegue);
}
class ConcreteMediator implements Mediator {
    List<Collegue> collegues = new ArrayList<>();
    void add(Collegue collegue) {
        collegues.add(collegue);
    }
    @Override
    public void requestAll(Collegue trueCollegue) {
        trueCollegue.setTrue();
        for (Collegue collegue : collegues) {
            if(collegue != trueCollegue) {
                collegue.setFalse();
            }
        }
    }
}
interface Collegue {
    void setTrue();
    void setFalse();
    void changeStatus();
}
class ConcreteCollegue implements Collegue {
    Mediator mediator;

    boolean status;

    public ConcreteCollegue(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void setTrue() {
        status = true;
        System.out.println("My status is: " + status);
    }

    @Override
    public void setFalse() {
        status = false;
        System.out.println("My status is: " + status);
    }

    @Override
    public void changeStatus() {
        mediator.requestAll(this);
    }
}