package lombok;

public class NonNullLesson {
    public static void main(String[] args) {
        LombokStudent.print(null);
    }
    static class LombokStudent {
        static void print(@NonNull String s) {
            System.out.println(s.toUpperCase());
        }
    }
    static class Student {
        static void print(String s) {
            if(s == null)
                throw new NullPointerException("student");
            System.out.println(s.toUpperCase());
        }
    }
}
