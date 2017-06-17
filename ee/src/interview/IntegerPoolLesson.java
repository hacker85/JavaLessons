package interview;

public class IntegerPoolLesson {
    public static void main(String[] args) {
        Byte by = 127;
        Short sh = 127;
        Integer a = 128;
        Integer b = 128;
//        128
//        System.out.println(a == b);
//        a++;
//        System.out.println(a == b);
//        System.out.println(b);

        System.out.println(a == b);
        System.out.println(a.equals(b));
    }
}
