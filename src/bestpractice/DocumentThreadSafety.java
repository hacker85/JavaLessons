package bestpractice;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class DocumentThreadSafety {
    public static void main(String[] args) {
//        immutable
        String s;
        Long l;
        BigInteger bigInteger;
//        unconditionally thread-safe
        Random random;
        ConcurrentHashMap concurrentHashMap;
//        conditionally thread-safe
        Collections.unmodifiableList(new ArrayList<>());
//        not thread-safe
        ArrayList arrayList;
//        thread-hostile
        System.runFinalizersOnExit(true);
    }
}
