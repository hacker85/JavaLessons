package interview;

public class StaticCallLesson {
    public static void main(String[] args) {
        StaticCallLesson staticCallLesson = null;
        staticCallLesson.print();
        StaticCallLesson.print();
    }
    static void print() {
        System.out.println("print");
    }
}
