package interview;

public class VolatileHappensBeforeLesson {
    static int a = 0;
    static int b = 0;
    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                int r2 = a;
                b = 1;
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                int r1 = b;
                a = 2;
            }
        }.start();
        //r2 = 2; r1 = 1 impossible
    }
}
