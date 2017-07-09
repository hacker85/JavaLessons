package interview;

public class ThreadLocalLesson {
    static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    public static void main(String[] args) throws InterruptedException {
        threadLocal.set("zero");
        Thread first = new FirstThread();
        Thread second = new SecondThread();
        first.start();
        second.start();
        first.join();
        second.join();
        System.out.println("Inner " + threadLocal.get());

    }
    static class FirstThread extends Thread {
        @Override
        public void run() {
            threadLocal.set("one");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("FirstThread " + threadLocal.get());
        }
    }
    static class SecondThread extends Thread {
        @Override
        public void run() {
            threadLocal.set("two");
            System.out.println("SecondThread " + threadLocal.get());
        }
    }
}
