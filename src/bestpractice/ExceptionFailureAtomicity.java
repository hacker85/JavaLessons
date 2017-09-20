package bestpractice;

import java.util.EmptyStackException;

//failed method invocation should leave the object in the state that it was in prior to the invocation
//1. immutable objects
//2. check params before use
//3. recovery code
//4. temporary copy
public class ExceptionFailureAtomicity {
    Object[] elements;
    public Object pop(int size) {
        if (size == 0)
            throw new EmptyStackException();
        return elements[--size];
    }
}
