package bestpractice;

//use wait and notify bad practice
//use the wait loop idiom to invoke the wait method
//1. Another thread could obtained lock and changed the state between thread invoked notify and the time the waiting thread woke
//2. Someone could call notifyAll
//use notifyAll
//1. you’ll wake the threads that need to be awakened
//2. wake some other threads won’t affect the correctness of your program

public class WaitAndNotify {
    Object object;
    public void waitMethod() throws InterruptedException {
        synchronized (object) {
            boolean condition = true;
            while (condition)
                object.wait();
        }
    }
    public void notifyMethod() {
        object.notifyAll();
    }
}
