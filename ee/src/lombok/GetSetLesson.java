package lombok;

public class GetSetLesson {
    public static void main(String[] args) {
        LombokStudent lombokStudent = new LombokStudent();
        lombokStudent.setAge(22);
        System.out.println(lombokStudent.getAge());
    }
    static class LombokStudent {
        @Getter @Setter(AccessLevel.PUBLIC)
        int age;
    }
}
