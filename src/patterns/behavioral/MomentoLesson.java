package patterns.behavioral;

public class MomentoLesson {
    public static void main(String[] args) {
        Originator originator = new Originator();
        CareTaker careTaker = new CareTaker();
        originator.setState("one");
        careTaker.createMomento(originator);
        originator.setState("two");
        originator.setMomento(careTaker.getMomento());
        System.out.println(originator.getState());
    }
}
class CareTaker {
    Momento momento;
    void createMomento(Originator originator){
        this.momento = originator.createMomento();
    }
    Momento getMomento(){
        return momento;
    }
}

class Originator {
    String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    Momento createMomento() {
        return new Momento(state);
    }

    void setMomento(Momento momento) {
        this.state = momento.getState();
    }
}

class Momento {
    String state;

    Momento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}