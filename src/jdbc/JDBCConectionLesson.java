package jdbc;

import java.sql.*;

public class JDBCConectionLesson {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql:lessons";
        String username = "max";
        String password = "1";
        try(Connection conn = DriverManager.getConnection(url, username, password);
            Statement stat = conn.createStatement()) {
            stat.executeUpdate("CREATE TABLE Books(id MEDIUMINT NOT NULL AUTO_INCREMENT, name CHAR(30) NOT NULL, PRIMARY KEY (id))");
            stat.executeUpdate("INSERT INTO Books (name) VALUES ('Inferno')");
            stat.executeUpdate("INSERT INTO Books SET name = 'Solomon key' ");
            ResultSet rs = stat.executeQuery("SELECT * FROM Books");
            while (rs.next()) {
                System.out.println(rs.getInt("id"));
                System.out.println(rs.getString(2));
            }
        }
    }
}
