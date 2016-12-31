package advanced;

public class OverridingAdvancedLesson {
    void method(Parent p) {
        System.out.println("parent");
    }
    void method(Child c) {
        System.out.println("child");
    }
    public static void main(String[] args) {
        OverridingAdvancedLesson overridingAdvancedLesson = new OverridingAdvancedLesson();
        overridingAdvancedLesson.method(null);

        overridingAdvancedLesson.equals(null);
    }
}
class Parent {

}
class Child extends Parent {

}


