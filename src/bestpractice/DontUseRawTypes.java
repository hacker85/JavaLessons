package bestpractice;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

//dont use raw types
//two exceptions: 1) List<String>.class 2) instanceof
public class DontUseRawTypes {
    public static void main(String[] args) {
        List<String> x = new ArrayList<>();
        if(x instanceof List) {
            List<?> y = x;
        }
    }
    static int numElementsInCommon(Set<?> s1, Set<?> s2) {
        int result = 0;
        for (Object o1 : s1)
            if (s2.contains(o1))
                result++;
        return result;
    }
}
