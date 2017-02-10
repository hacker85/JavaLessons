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
public class BatchLesson {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, XMLStreamException, TransformerException, XPathExpressionException, SQLException, ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/Lessons";
        String username = "root";
        String password = "1";
        Class.forName("com.mysql.jdbc.Driver");
        try(Connection conn = DriverManager.getConnection(url, username, password);
            Statement stat = conn.createStatement()) {
            conn.setAutoCommit(false);
            stat.addBatch("drop table IF EXISTS Books");
            stat.addBatch("CREATE TABLE IF NOT EXISTS Books (id MEDIUMINT NOT NULL AUTO_INCREMENT, name CHAR(30) NOT NULL, PRIMARY KEY (id))");
            stat.addBatch("INSERT INTO Books (name) VALUES ('Inferno')");
            stat.addBatch("INSERT INTO Books (name) VALUES ('DaVinchi Code')");
            stat.addBatch("INSERT INTO Books (name) VALUES ('Solomon key')");

            if(stat.executeBatch().length == 5) {
                conn.commit();
            } else {
                conn.rollback();
            }
        }
    }
}
