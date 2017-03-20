package patterns.behavioral;

public class StateLesson {
    public static void main(String[] args) {
        Context context = new Context(new LeverCaseState(), "Max");
        context.doAction();
        context.setState(new UpperCaseState());
        context.doAction();
    }
}

interface State {
    void doAction(Context context);
}

class LeverCaseState implements State {
    @Override
    public void doAction(Context context) {
        System.out.println(context.name.toLowerCase());
    }
}

class UpperCaseState implements State {
    @Override
    public void doAction(Context context) {
        System.out.println(context.name.toUpperCase());
    }
}

class Context {
    State state;
    String name;

    public Context(State state, String name) {
        this.state = state;
        this.name = name;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void doAction() {
        state.doAction(this);
    }
}