package jdbc;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;
import java.sql.*;

/**
 * Created by max on 2/8/17.
 */
public class MetadataLesson {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, XMLStreamException, TransformerException, XPathExpressionException, SQLException, ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/Lessons";
        String username = "root";
        String password = "1";
        Class.forName("com.mysql.jdbc.Driver");
        try(Connection conn = DriverManager.getConnection(url, username, password);
            Statement stat = conn.createStatement()) {
            stat.execute("drop table IF EXISTS Books");
            stat.executeUpdate("CREATE TABLE IF NOT EXISTS Books (id MEDIUMINT NOT NULL AUTO_INCREMENT, name CHAR(30) NOT NULL, PRIMARY KEY (id))");

            DatabaseMetaData databaseMetaData = conn.getMetaData();
            databaseMetaData.nullPlusNonNullIsNull();//haha
            ResultSet resultSet = databaseMetaData.getTables(null, null, null, new String[] {"TABLE" });
            while (resultSet.next()) {
                System.out.println(resultSet.getString(3));
            }

            ResultSet resultSet2 = stat.executeQuery("select * from Books");
            ResultSetMetaData resultSetMetaData = resultSet2.getMetaData();
            for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                System.out.println(resultSetMetaData.getColumnLabel(i));
            }
        }
    }
}
