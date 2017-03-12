package generics;

public class GenMethodsLesson {
    public static void main(String[] args) {
        new GenClass<Integer>("");
    }
}

class GenClass<T> {
    <X> GenClass(X x) {

    }
    T getT() {
        return null;
    }
    public <E> E method() {
        return null;
    }
}
class UsualClass {
    public <T> T method() {
        return null;
    }
}
