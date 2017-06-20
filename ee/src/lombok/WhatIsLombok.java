package lombok;

public class WhatIsLombok {
    public static void main(String[] args) {
        LombokStudent lombokStudent = new LombokStudent();
        Student student = new Student();
        lombokStudent.setAge(22);
        System.out.println(lombokStudent.getAge());
        System.out.println(lombokStudent.hashCode());
        System.out.println(lombokStudent.equals(new LombokStudent()));
        System.out.println(lombokStudent.toString());
        System.out.println(lombokStudent.canEqual(new LombokStudent()));
    }
    static @Data class LombokStudent {
        int age;
        String name;
    }
    static class Student {
        int age;
        String name;
    }
}
