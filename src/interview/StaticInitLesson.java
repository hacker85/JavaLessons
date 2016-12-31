package interview;

public class StaticInitLesson {
    static {
        i = 10;
    }
    static int i = 0;
    static {
        ++i;
    }
    public static void main(String[] args) {
        new StaticInitLesson();
        System.out.println(i);
    }
}
