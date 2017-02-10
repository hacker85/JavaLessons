package jdbc.transactionisolationlevel;

import java.sql.*;

/**
 * Created by max on 2/10/17.
 */
public class PhantomReadLesson {
    static String url = "jdbc:mysql://localhost:3306/Lessons";
    static String username = "root";
    static String password = "1";
    public static void main(String[] args) throws SQLException, InterruptedException {
        try(Connection conn = DriverManager.getConnection(url, username, password);
            Statement statement = conn.createStatement()) {
            conn.setAutoCommit(false);
            conn.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
            ResultSet rs = statement.executeQuery("Select count(*) from Books");
            while(rs.next()){
                System.out.println(rs.getInt(1));
            }
            new OtherTransaction2().start();
            Thread.currentThread().sleep(1000);
            rs = statement.executeQuery("Select count(*) from Books");
            while(rs.next()){
                System.out.println(rs.getString(1));
            }
        }
    }

    static class OtherTransaction2 extends Thread {
        @Override
        public void run() {
            try(Connection conn = DriverManager.getConnection(url, username, password);
                Statement stmt = conn.createStatement()) {
                conn.setAutoCommit(false);
                conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
                stmt.executeUpdate("insert into Books (name) VALUES ('new Row')");
                conn.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
