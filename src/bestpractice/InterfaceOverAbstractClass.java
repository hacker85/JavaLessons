package bestpractice;

import java.util.AbstractCollection;
import java.util.AbstractList;
import java.util.AbstractMap;
import java.util.AbstractSet;

//Existing classes can be easily retrofitted to implement a new interface
//Interfaces are ideal for defining mixin
//With abstract classes we shall use inheritance - it's dangerous
//providing an abstract skeletal implementation // AbstractName
//add new method to abstract class in new release
public class InterfaceOverAbstractClass {
    public static void main(String[] args) {
        AbstractCollection abstractCollection;
        AbstractSet abstractSet;
        AbstractList abstractList;
        AbstractMap abstractMap;
    }
}

interface Artist {
}

interface Singer {
}

interface ArtistSinger extends Artist, Singer {
}

class MyList extends AbstractList<Integer> {
    final int[] a;
    MyList(int[] a) {
        this.a = a;
    }
    public Integer get(int i) {
        return a[i];
    }
    @Override
    public Integer set(int i, Integer val) {
        int oldVal = a[i];
        a[i] = val;
        return oldVal;
    }
    public int size() {
        return a.length;
    }
}
