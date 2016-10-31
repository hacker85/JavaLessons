package multithreading.a7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by max on 10/16/16.
 */
public class SyncColletions {

    public static void main(String[] args) {
        NamedList namedList = new NamedList();
        namedList.add("Max");

        class MyThread extends Thread {
            @Override
            public void run() {
                System.out.println(namedList.removeFirst());
            }
        }

        MyThread myThread = new MyThread();
        myThread.setName("one");
        myThread.start();

        new MyThread().start();
    }

    static class NamedList {
        List<String> list = Collections.synchronizedList(new ArrayList<>());

        public synchronized void add(String name) {
            list.add(name);
        }

        public synchronized String removeFirst() {
            if(list.size() > 0) {
                if(Thread.currentThread().getName().equals("one")) {
                    Thread.yield();
                }
                return (String)list.remove(0);
            }
            return null;
        }
    }
}
