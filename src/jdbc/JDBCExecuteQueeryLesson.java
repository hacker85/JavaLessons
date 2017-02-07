package jdbc;

import java.sql.*;

/**
 * Created by max on 2/7/17.
 */
public class JDBCExecuteQueeryLesson {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/Lessons";
        String username = "root";
        String password = "1";
        Class.forName("com.mysql.jdbc.Driver");
        try(Connection conn = DriverManager.getConnection(url, username, password);
            Statement stat = conn.createStatement()) {
            stat.execute("drop table Books");
            stat.executeUpdate("CREATE TABLE IF NOT EXISTS Books (id MEDIUMINT NOT NULL AUTO_INCREMENT, name CHAR(30) NOT NULL, PRIMARY KEY (id))");
            stat.executeUpdate("INSERT INTO Books (name) VALUES ('Inferno')");
            stat.executeUpdate("INSERT INTO Books SET name = 'Solomon key' ");
            ResultSet rs = stat.executeQuery("SELECT * FROM Books");
            while (rs.next()) {
                System.out.println(rs.getInt("id"));
                System.out.println(rs.getString(2));
            }

            //Statement st = conn.createStatement();
            ResultSet rs2 = stat.executeQuery("SELECT name FROM Books where id = 1");
            while (rs2.next()) {
                System.out.println(rs2.getString("name"));
            }
        }
    }
}
