package jdbc;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;
import java.sql.*;

/**
 * Created by max on 2/7/17.
 */
public class MultipleResultsLesson {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, XMLStreamException, TransformerException, XPathExpressionException, SQLException, ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/Lessons";
        String username = "root";
        String password = "1";
        Class.forName("com.mysql.jdbc.Driver");
        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stat = conn.createStatement()) {
            stat.execute("drop table IF EXISTS Books");
            stat.executeUpdate("CREATE TABLE IF NOT EXISTS Books (id MEDIUMINT NOT NULL AUTO_INCREMENT, name CHAR(30) NOT NULL, PRIMARY KEY (id))");
            stat.executeUpdate("insert into Books (name) values ('Inferno')");
            stat.executeUpdate("insert into Books (name) values ('Solomon key')");

            CallableStatement callableStatement = conn.prepareCall("{call getCount()}");
            boolean hadResults = callableStatement.execute();
            while (hadResults) {
                ResultSet resultSet = callableStatement.getResultSet();
                while (resultSet.next()) {
                    System.out.println(resultSet.getInt(1));
                }
                System.out.println("------------");
                hadResults = callableStatement.getMoreResults();
            }
        }
    }
}
