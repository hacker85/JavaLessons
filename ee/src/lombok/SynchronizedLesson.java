package lombok;

public class SynchronizedLesson {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            new Thread() {
                @Override
                public void run() {
                    LombokStudent.increment();
                }
            }.start();
        }
        Thread.sleep(500);
        System.out.println(LombokStudent.i);
    }
    static class LombokStudent {
        static int i;
        @Synchronized
        static void increment() {
            i++;
        }
    }
}
