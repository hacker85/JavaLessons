package jdbc.transactionisolationlevel;

import java.sql.*;

/**
 * Created by max on 2/8/17.
 */
public class DirtyReadLesson {
    static String url = "jdbc:mysql://localhost:3306/Lessons";
    static String username = "root";
    static String password = "1";

    public static void main(String[] args) throws SQLException, InterruptedException {
        new OtherTransaction().start();
        Thread.currentThread().sleep(500);
        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement()) {
            conn.setAutoCommit(false);
            conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            //conn.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
            ResultSet rs = stmt.executeQuery("Select name from Books where id = 1");
            while (rs.next()){
                System.out.println("Book name is:" + rs.getString("name"));
            }
        }
    }

    static class OtherTransaction extends Thread {
        @Override
        public void run() {
            try(Connection conn = DriverManager.getConnection(url, username, password);
                PreparedStatement stmt = conn.prepareStatement("Update Books set name = 'new Name' where id = 1")) {
                conn.setAutoCommit(false);
                stmt.execute();
                Thread.currentThread().sleep(2000);
                conn.rollback();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}


