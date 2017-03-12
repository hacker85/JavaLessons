package regexp;

public class AtomicGroupLesson {
    public static void main(String[] args) {
        //(?>group)
        System.out.println("abcc".matches("a(bc|b)c"));
        System.out.println("abc".matches("a(bc|b)c"));

        System.out.println("abcc".matches("a(?>bc|b)c"));
        System.out.println("abc".matches("a(?>bc|b)c"));

        System.out.println("integers".matches("\\b(integer|insert|in)\\b"));
        System.out.println("integers".matches("\\b(?>integer|insert|in)\\b"));
    }
}
