package bestpractice;

import java.util.AbstractCollection;
import java.util.AbstractList;
import java.util.Date;

//document for inheritance
//which method we invoke? and how does it affect //in which circumstances it should be invoke i.e. background threads or static initializers
//The description begins with the phrase “This implementation.”
//inheritance violates encapsulation
//class may have to provide hooks into its internal workings in the form of judiciously chosen protected methods
//The only way to test a class designed for inheritance is to write subclasses
//Constructors must not invoke overridable methods //NullPointerException
//Cloneable and Serializable //neither clone nor readObject may invoke an overridable method //readResolve or writeReplace method protected
//good - skeletal implementations of interfaces
//prohibit subclassing in classes that are not designed and documented to be safely subclassed //final class is bad
public class DesignForInheritance {
    public static void main(String[] args) {
        AbstractCollection abstractCollection;
        AbstractList abstractList;
        Sub sub = new Sub();
        sub.overrideMe();
    }
}

class Super {
    public Super() {
        overrideMe();
    }
    public void overrideMe() {
    }
}
class Sub extends Super {
    private final Date date;
    public Sub() {
        date = new Date();
    }
    @Override public void overrideMe() {
        System.out.println(date);
    }
}
