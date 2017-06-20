package lombok;

public class EqualsAndHashCodeLesson {
    public static void main(String[] args) {
        LombokStudent lombokStudent = new LombokStudent();
        lombokStudent.age = 22;
        lombokStudent.name = "Max";
        LombokStudent lombokStudent2 = new LombokStudent();
        lombokStudent2.age = 22;
        lombokStudent2.name = "Max";
        System.out.println(lombokStudent.equals(lombokStudent2));
        System.out.println(lombokStudent.hashCode());
    }
    @EqualsAndHashCode(exclude = "id")
    static class LombokStudent {
        int id;
        int age;
        String name;
    }
}
