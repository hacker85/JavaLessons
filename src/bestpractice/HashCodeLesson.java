package bestpractice;

import java.util.HashMap;
import java.util.Map;

//example with map
//12
//31
//all fields? // id
public class HashCodeLesson {
    int id;
    int j;
    public static void main(String[] args) {
        Map<HashCodeLesson,String> map = new HashMap<>();
        map.put(new HashCodeLesson(), "one");
        System.out.println(map.get(new HashCodeLesson()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HashCodeLesson that = (HashCodeLesson) o;

        return id == that.id  && j == that.j;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
