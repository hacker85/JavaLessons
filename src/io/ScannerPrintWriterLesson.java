package io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ScannerPrintWriterLesson {
    public static void main(String[] args) throws IOException {
        try(Scanner scanner = new Scanner(new FileReader("temp.txt"))) {
            while (scanner.hasNext()) {
                System.out.println(scanner.next());
            }
        }

        try(PrintWriter writer = new PrintWriter(new FileWriter("temp.txt"))) {
            writer.write("str1");
            writer.write("\n");
            writer.write("str2");
        }
    }
}
