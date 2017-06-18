package interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImmutableLesson {
    public static void main(String[] args) {
        ImmutableClass myImmutable = new ImmutableClass(5, new ArrayList<String>(), "hello", new Person(), new Object());
        myImmutable.getPerson().age = 5;
        System.out.println(myImmutable.getPerson().age);
    }
    final static class ImmutableClass {
        private final int i;
        private final List<String> list;
        private final String s;
        private final Person person;
        private final Object o;

        public ImmutableClass(int i, List<String> list, String s, Person person, Object o) {
            this.i = i;
            this.list = Collections.unmodifiableList(cloneList(list));
            this.s = s;
            this.person = person;
            this.o = o;
        }
        public static List<String> cloneList(List<String> list) {
            List<String> clone = new ArrayList<String>(list.size());
            for (String item : list)
                clone.add(item);
            return clone;
        }

        public int getI() {
            return i;
        }

        public List<String> getList() {
            return list;
        }

        public String getS() {
            return s;
        }

        public Person getPerson() {
            return (Person)person.clone();
        }

        public Object getO() {
            return o;
        }
    }
    static class Person implements Cloneable {
        int age;
        @Override
        protected Object clone() {
            try {
                return super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}
