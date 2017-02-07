package jdbc;

import java.sql.*;

/**
 * Created by max on 2/7/17.
 */
public class StoredPrcedureLesson {
    public static void main(String[] args) throws ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/Lessons";
        String username = "root";
        String password = "1";
        Class.forName("com.mysql.jdbc.Driver");
        try(Connection conn = DriverManager.getConnection(url, username, password);
            Statement stat = conn.createStatement()) {
            stat.execute("drop table IF EXISTS Books");
            stat.executeUpdate("CREATE TABLE IF NOT EXISTS Books (id MEDIUMINT NOT NULL AUTO_INCREMENT, name CHAR(30) NOT NULL, PRIMARY KEY (id))");
            stat.executeUpdate("insert into Books (name) values ('Inferno')");
            stat.executeUpdate("insert into Books (name) values ('Solomon key')");

            CallableStatement callableStatement = conn.prepareCall("{call BooksCount(?)}");
            callableStatement.registerOutParameter(1, Types.INTEGER);
            callableStatement.execute();
            System.out.println(callableStatement.getInt(1));
            System.out.println("--------------");

            CallableStatement callableStatement2 = conn.prepareCall("{call getBooks(?)}");
            callableStatement2.setInt(1, 1);
            if (callableStatement2.execute()) {
                ResultSet resultSet = callableStatement2.getResultSet();
                while (resultSet.next()) {
                    System.out.println(resultSet.getInt("id"));
                    System.out.println(resultSet.getString("name"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
