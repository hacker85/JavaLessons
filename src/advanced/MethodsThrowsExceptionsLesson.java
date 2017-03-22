package advanced;

import java.io.FileNotFoundException;
import java.io.IOException;

public class MethodsThrowsExceptionsLesson {
    public static void main(String[] args) {
//        throw new Error();
//        throw new Exception();
//        throw new Throwable();
//        throw new RuntimeException();
//        throw new FileNotFoundException();
    }

    void method1() throws Error {}
    void method2() throws Exception {}
    void method3() throws Throwable {}
    void method4() throws RuntimeException {}
    void method5() throws FileNotFoundException {}

    void method6() {
        try {}
        catch (Error e) {}
    }
    void method7() {
        try {}
        catch (Exception e) {}
    }
    void method8() {
        try {}
        catch (Throwable e) {}
    }
    void method9() {
        try {}
        catch (RuntimeException e) {}
    }
    void method10() {
//        try {}
//        catch (FileNotFoundException e) {}
    }
}

//class Base {
//    public void aMethod() {}
//    public void noRuntimeException() {}
//}
//
//class Derived extends Base {
////    public void aMethod() throws Exception {}
//    public void noRuntimeException() throws RuntimeException {}
//}

//class Base {
//    public void aMethod() throws IOException {}
//    public void withRuntimeException() throws RuntimeException {}
//}
//class Derived1 extends Base {
//    public void aMethod() {}
//    public void withRuntimeException() {}
//}

//class Base {
//    public void aMethod() throws IOException {}
//    public void withRuntimeException() throws NullPointerException {}
//}
//class Derived2 extends Base {
//    public void aMethod() throws Exception {}
//    public void withRuntimeException() throws RuntimeException{}
//}
//class Base {
//    void aMethod() throws IOException {}
//    void methodUncheckedEx() throws Error {}
//}
//class Derived3 extends Base {
//    void aMethod() throws IOException {}
//    void methodUncheckedEx() throws NullPointerException {}
//}
class Base {
    void aMethod() throws IOException {}
}
class Derived4 extends Base {
    void aMethod() throws FileNotFoundException {}
}