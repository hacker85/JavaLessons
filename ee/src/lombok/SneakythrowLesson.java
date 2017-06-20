package lombok;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SneakythrowLesson {
    public static void main(String[] args) {
        LambokStudent.readFile();
    }
    static class LambokStudent {
        @SneakyThrows(IOException.class)
        public static void readFile() {
            Scanner scanner = new Scanner(new FileReader(new File("temp.txt")));
            while(scanner.hasNext())
                System.out.println(scanner.next());
        }
    }
}
