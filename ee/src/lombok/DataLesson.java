package lombok;

public class DataLesson {
    public static void main(String[] args) {
        LombokStudent lombokStudent = new LombokStudent(22);
        Student student = new Student();
        lombokStudent.setAge(22);
        System.out.println(lombokStudent.getAge());
        System.out.println(lombokStudent.hashCode());
        System.out.println(lombokStudent.equals(new WhatIsLombok.LombokStudent()));
        System.out.println(lombokStudent.toString());
        System.out.println(lombokStudent.canEqual(new WhatIsLombok.LombokStudent()));
    }
    static @Data class LombokStudent {
        @NonNull
        int age;
        String name;
    }
    static class Student {
        int age;
        String name;
    }
}
