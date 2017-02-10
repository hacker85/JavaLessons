import java.sql.*;

public class Main {
    static String url = "jdbc:mysql://localhost:3306/Lessons";
    static String username = "root";
    static String password = "1";

    public static void main(String[] args) throws SQLException, InterruptedException {
        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement()) {
            conn.setAutoCommit(false);
            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            ResultSet resultSet = stmt.executeQuery("select count(*) from Books");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1));
            }

            new OtherTransaction().start();
            Thread.sleep(2000);

            ResultSet resultSet2 = stmt.executeQuery("select count(*) from Books");
            while (resultSet2.next()) {
                System.out.println(resultSet2.getInt(1));
            }
        }
    }

    static class OtherTransaction extends Thread {
        @Override
        public void run() {
            try (Connection conn = DriverManager.getConnection(url, username, password);
                 Statement stmt = conn.createStatement()) {
                conn.setAutoCommit(false);
                conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
                stmt.executeUpdate("insert into Books (name) VALUES ('new value')");
                conn.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}