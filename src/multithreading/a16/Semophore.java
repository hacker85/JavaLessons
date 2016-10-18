package multithreading.a16;

import java.util.concurrent.Semaphore;

/**
 * Created by husiv on 10/18/16.
 */
public class Semophore {
    public static void main(String[] args) {
        Semaphore tables = new Semaphore(2);

        Person[] persons = new Person[]{new Person(),new Person(),new Person(),new Person(),new Person(),new Person(),new Person(),new Person()};

        for (Person person: persons) {
            person.table = tables;
            person.start();
        }

    }

    static class Person extends Thread {
        Semaphore table;

        @Override
        public void run() {
            System.out.println(getName() + "waiting");
            try{
                table.acquire();
                System.out.println(getName() + " eat at the table");
                sleep(1000);
                System.out.println(getName() + " realease table");
                table.release();
            } catch (InterruptedException e) {
            }
        }
    }
}
