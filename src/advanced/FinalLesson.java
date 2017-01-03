package advanced;

public class FinalLesson {
    public static void main(String[] args) {
        One one = new Two();
        one.executeMathod();
    }
}

class One {
    private final void method() {
        System.out.println("one");
    }
    void executeMathod() {
        One one = new Two();
        one.method();
    }
}
class Two extends One {
    void method() {
        System.out.println("two");
    }
}