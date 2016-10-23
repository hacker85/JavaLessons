package multithreading.a25;

import java.io.*;

/**
 * Created by max on 10/23/16.
 */
public class DeamonLesson {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    File file = new File("/home/max/test.txt");
                    if (!file.exists()) {
                        try {
                            file.createNewFile();
                        } catch (IOException e) {
                        }
                    }
                    try {
                        BufferedReader reader = new BufferedReader(new FileReader(file));
                        String str = reader.readLine();
                        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                        writer.write(str + "1");
                        writer.flush();
                        writer.close();
                    } catch (IOException e) {
                    }
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                    }
                }
            }
        };
        thread.setDaemon(true);
        thread.start();
        Thread.sleep(1000);
    }
}
