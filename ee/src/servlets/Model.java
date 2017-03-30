package servlets;

import jsp.Student;

public class Model {
    public Student getData() {
        Student student = new Student();
        student.setName("Max");
        student.setAge(22);
        return student;
    }
}
