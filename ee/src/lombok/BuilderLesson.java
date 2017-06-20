package lombok;

import java.util.List;

public class BuilderLesson {
    public static void main(String[] args) {
        LombokStudent lombokStudent = LombokStudent.builder().age(22).name("Max").mark("1").mark("2").build();
        System.out.println(lombokStudent.age);
        System.out.println(lombokStudent.name);
        for (String mark : lombokStudent.marks) {
            System.out.println(mark);

        }
    }
    @Builder
    static class LombokStudent {
        int age;
        String name;
        @Singular
        List<String> marks;

    }
}
