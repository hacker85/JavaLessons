package multithreading.a18;

import java.util.concurrent.Exchanger;

/**
 * Created by husiv on 10/18/16.
 */
public class Excenger {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();

        new Mike(exchanger);
        new ApplicationForm(exchanger);
    }
    static class Mike extends Thread {
        Exchanger<String> exchanger;

        public Mike(Exchanger<String> exchanger) {
            this.exchanger = exchanger;
            start();
        }

        @Override
        public void run() {
            try {
                exchanger.exchange("Hi, my name is Mike");
                sleep(1000);
                exchanger.exchange("I'm 20 years old");
            } catch (InterruptedException e) {
            }
        }
    }
    static class ApplicationForm extends Thread {
        Exchanger<String> exchanger;

        public ApplicationForm(Exchanger<String> exchanger) {
            this.exchanger = exchanger;
            start();
        }

        @Override
        public void run() {
            try {
                System.out.println(exchanger.exchange(null));
                System.out.println(exchanger.exchange(null));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
