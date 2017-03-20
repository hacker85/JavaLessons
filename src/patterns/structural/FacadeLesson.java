package patterns.structural;

import java.io.*;

public class FacadeLesson {
    public static void main(String[] args) throws IOException {
        FileReadFacade fileReadFacade = new FileReadFacade();
        System.out.println(fileReadFacade.readFile("temp.txt"));
    }
}

class FileReadFacade {
    String readFile(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        StringBuilder stringBuilder = new StringBuilder();
        int j = 0;
        while((j = reader.read()) != -1) {
            stringBuilder.append((char)j);
        }
        return stringBuilder.toString();
    }
}