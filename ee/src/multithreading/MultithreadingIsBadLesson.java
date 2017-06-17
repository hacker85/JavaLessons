package multithreading;

public class MultithreadingIsBadLesson {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Counter counter = new Counter();
        for (int i = 0; i < 1_000_000_000; i++) {
            counter.increase();
        }
        System.out.println(System.currentTimeMillis() - start);
    }
    static class Counter {
        int i;
        synchronized void increase() {
            i++;
        }
    }
}
