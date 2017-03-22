package java8;

import java.util.ArrayList;
import java.util.List;

public class DefaultMethodsLesson {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.stream();
        System.out.println(Parent.add(5, 5));
        Parent parent = new Child();
        parent.callPrint();

        B b = new D();
        b.exec();
    }
}
interface Parent {
    void printMessage(String message);

    default void callPrint() {
        printMessage("hello");
    }
    static int add(int x, int y) {
        return x + y;
    }
}

class Child implements Parent {
    @Override
    public void printMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void callPrint() {
        printMessage("test");
    }
}

interface B {
    default void exec() {
        System.out.println("B");
    }
}
interface C extends B {
    default void exec() {
        System.out.println("C");
    }
}
class D implements B, C {
//    @Override
//    public void exec() {
//        System.out.println("D");
//    }
}