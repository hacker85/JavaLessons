package jdbc;

import java.sql.*;

/**
 * Created by max on 2/7/17.
 */
public class PrepareStatemantLesson {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/Lessons";
        String username = "root";
        String password = "1";
        Class.forName("com.mysql.jdbc.Driver");
        try(Connection conn = DriverManager.getConnection(url, username, password);
            Statement stat = conn.createStatement()) {
            stat.execute("drop table Users");
            stat.executeUpdate("CREATE TABLE IF NOT EXISTS Users (id MEDIUMINT NOT NULL AUTO_INCREMENT, name CHAR(30) NOT NULL, password CHAR(30) NOT NULL, PRIMARY KEY (id))");
            stat.executeUpdate("INSERT INTO Users (name, password) VALUES ('max', '123')");
            stat.executeUpdate("INSERT INTO Users SET name = 'otherGuy', password = '321' ");

            //String s = "1";
//            String s = "1' or 1 = '1";
//            //String s = "1; drop table Books";
//            ResultSet rs = stat.executeQuery("SELECT * FROM Users where id = '" + s + "'");
//            while (rs.next()) {
//                System.out.println("userName: " + rs.getString("name"));
//                System.out.println("userPassword: " + rs.getString("password"));
//            }

            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM Users where id = ?");
            preparedStatement.setString(1, "1' or 1 = '1");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id"));
                System.out.println(resultSet.getString("name"));
            }
        }
    }
}
