package collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetsLesson {
    public static void main(String[] args) {
        Set<Student> hashSet = new HashSet<>();
        Set<Student> linkedHashSet = new LinkedHashSet<>();
        Set<Student> treeSet = new TreeSet<>();
        treeSet.add(new Student(3));
        treeSet.add(new Student(1));
        treeSet.add(new Student(2));
        for(Student s : treeSet) {
            System.out.println(s.id);
        }

    }
    static class Student implements Comparable {
        int id;
        String name;

        public Student(int id) {
            this.id = id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Student student = (Student) o;

            if (id != student.id) return false;
            return name != null ? name.equals(student.name) : student.name == null;
        }

        @Override
        public int hashCode() {
            int result = id;
            result = 31 * result + (name != null ? name.hashCode() : 0);
            return result;
        }

        @Override
        public int compareTo(Object o) {
            return id - ((Student)o).id;
        }
    }
}
