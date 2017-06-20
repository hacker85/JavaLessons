package lombok;

public class ValueLesson {
    public static void main(String[] args) {
        LambokStudent lambokStudent = new LambokStudent(22, "Max");
        System.out.println(lambokStudent.getAge());
        System.out.println(lambokStudent.getName());
//        lambokStudent.age = 5;
    }
    @Value
    static class LambokStudent {
        int age;
        String name;
    }
}
