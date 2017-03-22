package advanced;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MultiCatchLesson {
    public static void main(String[] args) {
        try {
            File file = new File("temp.txt");
            FileInputStream fin = new FileInputStream(file);
            Connection connection = DriverManager.getConnection("", "", "");
        } catch (FileNotFoundException | SQLException e) {
            System.out.println(e.toString());
//            e = new SQLException();
        } catch (IOException exception) {}
    }
}
