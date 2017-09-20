package bestpractice;

import java.util.*;

//inheritance is bad //in package is norm or good documented //interface is good
//inheritance violates encapsulation //subclass depends on the implementation details of its superclass
//override and verify all methods problem
//add new method could override in the future //and we don't know the contract
//it's wrapper//no performance and memory issues
//inheritance only if a is b //stack is not a vector //Properties -> Hashtable
//inheritance propagates any flaws, while composition lets you design a new API that hides these flaws
public class CompositionOverInheritance {
    public static void main(String[] args) {
        InstrumentedSet<String> s = new InstrumentedSet<>();
        s.addAll(Arrays.asList("Snap", "Crackle", "Pop"));
        System.out.println(s.getAddCount());
    }
}

class InstrumentedHashSet<E> extends HashSet<E> {
    private int addCount = 0;
    @Override public boolean add(E e) {
        if(e instanceof String) return false;
        addCount++;
        return super.add(e);
    }
    @Override public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return super.addAll(c);
    }
    public int getAddCount() {
        return addCount;
    }
}

class InstrumentedSet<E> {
    private int addCount = 0;
    private final Set<E> set = new HashSet<E>();

    public boolean add(E e) {
        if(e instanceof String) return false;
        addCount++;
        return set.add(e);
    }
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return set.addAll(c);
    }
    public int getAddCount() {
        return addCount;
    }
}