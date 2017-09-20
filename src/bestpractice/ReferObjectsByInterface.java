package bestpractice;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

//next release can improve performance
//but if it sync it should be sync
//if no interface it's ok
public class ReferObjectsByInterface {
    List<String> list = new ArrayList<>();//good
    static Vector<String> vector = new Vector<>();//bad
    public static void main(String[] args) {
        ThreadLocal threadLocal;
    }
}
