package interview;

public class InternalStringsLesson {
    public static void main(String[] args) {
        String one = "one";
        String two = new String("one").intern();
        System.out.println(one.equals(two));
        System.out.println(one == two);
    }
}
