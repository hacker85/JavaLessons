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
public class SqlDateAndEscapeLesson {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, XMLStreamException, TransformerException, XPathExpressionException, SQLException, ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/Lessons";
        String username = "root";
        String password = "1";
        Class.forName("com.mysql.jdbc.Driver");
        try(Connection conn = DriverManager.getConnection(url, username, password);
            Statement stat = conn.createStatement()) {
            stat.execute("drop table IF EXISTS Books");
            stat.executeUpdate("CREATE TABLE IF NOT EXISTS Books (id MEDIUMINT NOT NULL AUTO_INCREMENT, name CHAR(30) NOT NULL, dt DATE, PRIMARY KEY (id))");
//            PreparedStatement preparedStatement = conn.prepareStatement("insert into Books (name, dt) values ('Inferno', ?)");
//            preparedStatement.setDate(1, new Date(1486494048359L));
//            preparedStatement.execute();
//            System.out.println(preparedStatement);

            //stat.executeUpdate("insert into Books (name, dt) values ('Inferno', '2017-02-07')");
            stat.executeUpdate("insert into Books (name, dt) values ('Inferno', {d '2017-02-07'})");
            ResultSet resultSet = stat.executeQuery("SELECT * from Books");
            while (resultSet.next()) {
                System.out.println(resultSet.getDate("dt"));
            }
        }
    }
}
