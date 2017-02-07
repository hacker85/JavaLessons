package jdbc;

import java.sql.*;

public class JDBCConectionLesson {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/Lessons";
        String username = "root";
        String password = "1";
        Class.forName("com.mysql.jdbc.Driver");
        try(Connection conn = DriverManager.getConnection(url, username, password)) {
            System.out.println("We're connected");
        }
    }
}
