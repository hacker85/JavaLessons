package advanced;

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class TryWithResourcesLesson {
    static class MyLaptop implements AutoCloseable {
        @Override
        public void close() {

        }
    }
    public static void main(String[] args) {

        try(MyLaptop myClass = new MyLaptop();
            Reader reader = new FileReader(new File(""))) {
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //streams
        Reader reader;
        Writer writer;
        InputStream inputStream;
        OutputStream outputStream;
        //gdbc
        Connection connection;
        Statement statement;
        ResultSet resultSet;
    }
}
