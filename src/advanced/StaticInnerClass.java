package advanced;

public class StaticInnerClass {

    private static int i = 1;
    int j = 2;

    static class Inner {
        static int q = i;
        int w = 3;

        void method() {
            System.out.println("method");
        }

        int getI() {
            return i;
        }
    }
    class Inner3 extends Inner {
        void method() {
            System.out.println("inner3");
        }
    }

    public static void main(String[] args) {
        StaticInnerClass staticInnerClass = new StaticInnerClass();
        Inner inner = staticInnerClass.new Inner3();
        inner.method();
    }
}

class OtherClass extends StaticInnerClass.Inner {
    public static void main(String[] args) {
        StaticInnerClass.Inner inner = new StaticInnerClass.Inner();
        System.out.println(inner.getI());
    }
}
