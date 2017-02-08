package jdbc;

import com.sun.rowset.CachedRowSetImpl;
import org.xml.sax.SAXException;

import javax.sql.rowset.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;
import java.sql.*;

/**
 * Created by max on 2/8/17.
 */
public class RowSetLesson {
    static String url = "jdbc:mysql://localhost:3306/Lessons?relaxAutoCommit=true";
    static String username = "root";
    static String password = "1";

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, XMLStreamException, TransformerException, XPathExpressionException, SQLException, ClassNotFoundException {
        ResultSet resultSet = getData();
        while (resultSet.next()) {
            System.out.println(resultSet.getInt("id"));
            System.out.println(resultSet.getString("name"));
        }
        CachedRowSet cachedRowSet = (CachedRowSet)resultSet;
        cachedRowSet.setUrl(url);
        cachedRowSet.setUsername(username);
        cachedRowSet.setPassword(password);

//        cachedRowSet.setCommand("select * from Books where id = ?");
//        cachedRowSet.setInt(1, 1);
//        cachedRowSet.setPageSize(20);
//        cachedRowSet.execute();
//        do {
//            while (cachedRowSet.next()) {
//                System.out.println(cachedRowSet.getInt("id"));
//                System.out.println(cachedRowSet.getString("name"));
//            }
//        } while(cachedRowSet.nextPage());


        CachedRowSet cachedRowSet2 = (CachedRowSet)resultSet;
        cachedRowSet2.setTableName("Books");
        cachedRowSet2.absolute(1);
        cachedRowSet2.deleteRow();
        cachedRowSet2.beforeFirst();
        while (cachedRowSet2.next()) {
            System.out.println(cachedRowSet2.getInt("id"));
            System.out.println(cachedRowSet2.getString("name"));
        }
        cachedRowSet2.acceptChanges(DriverManager.getConnection(url, username, password));
//        cachedRowSet2.acceptChanges();
    }

    static ResultSet getData() throws ParserConfigurationException, IOException, SAXException, XMLStreamException, TransformerException, XPathExpressionException, SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        try(Connection conn = DriverManager.getConnection(url, username, password);
            Statement stat = conn.createStatement()) {
            stat.execute("drop table IF EXISTS Books");
            stat.executeUpdate("CREATE TABLE IF NOT EXISTS Books (id MEDIUMINT NOT NULL AUTO_INCREMENT, name CHAR(30) NOT NULL, PRIMARY KEY (id))");
            stat.executeUpdate("INSERT INTO Books (name) VALUES ('Inferno')", Statement.RETURN_GENERATED_KEYS);
            stat.executeUpdate("INSERT INTO Books (name) VALUES ('DaVinchi Code')", Statement.RETURN_GENERATED_KEYS);
            stat.executeUpdate("INSERT INTO Books (name) VALUES ('Solomon key')", Statement.RETURN_GENERATED_KEYS);

            RowSetFactory factory = RowSetProvider.newFactory();
            CachedRowSet crs = factory.createCachedRowSet();
            WebRowSet wrs = factory.createWebRowSet();
            FilteredRowSet frs = factory.createFilteredRowSet();
            JoinRowSet jrs = factory.createJoinRowSet();
            JdbcRowSet jdrs = factory.createJdbcRowSet();
            CachedRowSet cachedRowSet = new CachedRowSetImpl();

            Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet = statement.executeQuery("select * from Books");
            cachedRowSet.populate(resultSet);
            return cachedRowSet;
        }
    }
}
