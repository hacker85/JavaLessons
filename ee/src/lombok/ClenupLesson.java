package lombok;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ClenupLesson {
    public static void main(String[] args) throws IOException {
        LombokStudent.writeToFile();
    }
    static class LombokStudent {
        static void writeToFile() throws IOException {
            @Cleanup
            PrintWriter printWriter = new PrintWriter(new FileWriter(new File("temp.txt")));
            printWriter.write("hello world");
        }
    }
    static class Student {
        static void writeToFile() throws IOException {
            try (PrintWriter printWriter = new PrintWriter(new FileWriter(new File("temp.txt")))) {
                printWriter.write("hello");
            }
        }
    }
}
