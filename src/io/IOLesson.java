package io;

import java.io.*;
import java.util.zip.ZipInputStream;

public class IOLesson {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("temp.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("temp.txt"));
        int j = 0;
        while((j = reader.read()) != -1) {
            System.out.println((char)j);
        }
        char[] chars = new char[50];
        while (reader.read(chars) != -1) {
            for (int i = 0; i < chars.length; i++) {
                if(Character.isAlphabetic(chars[i]) || Character.isWhitespace(chars[i])) {
                    System.out.println(chars[i]);
                }

            }
            //System.out.println(chars);
        }
        while(reader.read() != -1) {
            System.out.println(reader.readLine());
        }
        try(BufferedWriter writer2 = new BufferedWriter(new FileWriter("temp.txt"));)  {
            writer2.write("str1");
            writer2.newLine();
            writer2.write("str2");
        }
        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream("temp.txt"));
        int i = 0;
        while((i = inputStream.read()) != -1) {
            System.out.println(i);
        }
        byte[] bytes = new byte[inputStream.available()];
        while (inputStream.read(bytes) != -1) {
            for (int q = 0; q < bytes.length; q++) {
                System.out.println(bytes[q]);
            }
        }
        try(BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream("temp.txt"))) {
            byte[] bytes2 = new byte[] {49, 10, 50};
            outputStream.write(bytes2);
        }
        ZipInputStream zipInputStream = new ZipInputStream(new DataInputStream(new BufferedInputStream(new FileInputStream(""))));
    }
}
