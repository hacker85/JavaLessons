package interview;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class MemoryLeakExample {
    static GoodCache goodCache = new GoodCache();
    static BadCache badCache = new BadCache();
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100_000_000; i++) {
//            Thread.sleep(10);
            addGoodCache(i);
            addBadCache(i);
        }
    }
    private static void addGoodCache(int i) {
        goodCache.add(i);
    }
    private static void addBadCache(int i) {
        badCache.add(i);
    }
}

class GoodCache {
    Map<Integer, Integer> weakMap = new WeakHashMap<>();
    public void add(int i) {
        weakMap.put(i, i);
    }
}
class BadCache {
    Map<Integer, Integer> hashedMap = new HashMap();
    public void add(int i) {
        hashedMap.put(i, i);
    }
}
