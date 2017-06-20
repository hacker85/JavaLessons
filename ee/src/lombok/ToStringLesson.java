package lombok;

public class ToStringLesson {
    public static void main(String[] args) {
        System.out.println(new LombokStudent().toString());
    }
    @ToString(exclude = "id")
    static class LombokStudent {
        int id;
        int age;
        String name;
    }
}
