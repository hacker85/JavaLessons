package java8;

import java.util.function.*;

public class FunctionalInterfacesLesson {
    public static void main(String[] args) {
        Predicate<Integer> predicate = x -> x > 5;
        Consumer<Integer> consumer = x -> System.out.println(x);
        Function<Integer,String> function = x -> x.toString();
        Supplier<Integer> supplier = () -> new Integer(5);
        UnaryOperator<Integer> unaryOperator = x -> x * x;
        BinaryOperator<Integer> binaryOperator = (x,y) -> x * y;

        MyPredicate<Integer> myPredicate = x -> System.out.println(x);
        myPredicate.apply(5);
        MyPredicate2 myPredicate2 = () -> System.out.println("hello world");
        myPredicate2.apply();
    }
    interface MyPredicate<T> {
        void apply(T t);
    }
    public abstract static interface MyPredicate2 {
        void apply();
    }
}