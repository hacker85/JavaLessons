package advanced;

public class InnerClassLesson {

    private static int j = 6;
    private int i = 5;

    Inner inner = new Inner();

    void method() {
        Inner inner = new Inner();
    }

    class Inner {
        int q = j;
        int w = i;
        void method() {
            q = j + i;
        }

        final static int e = 4;
    }

    public static void main(String[] args) {
        Inner inner = new InnerClassLesson().new Inner();
    }
}
class OtherClass2 {
    InnerClassLesson.Inner inner = new InnerClassLesson().new Inner();
}
