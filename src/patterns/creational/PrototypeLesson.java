package patterns.creational;

public class PrototypeLesson {
    public static void main(String[] args) throws CloneNotSupportedException {
        Cash cash = new Cash();
        cash.setStudent(new Student());
        Student student = cash.getStudent();
    }
}

class Student implements Cloneable {
    @Override
    public Student clone() throws CloneNotSupportedException {
        return (Student)super.clone();
    }
}

class Cash {
    private Student student;

    public Student getStudent() throws CloneNotSupportedException {
        return student.clone();
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}