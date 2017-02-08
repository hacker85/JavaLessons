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
public class ScrolableSetLesson {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, XMLStreamException, TransformerException, XPathExpressionException, SQLException, ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/Lessons";
        String username = "root";
        String password = "1";
        Class.forName("com.mysql.jdbc.Driver");
        try(Connection conn = DriverManager.getConnection(url, username, password);
            Statement stat = conn.createStatement()) {
            stat.execute("drop table IF EXISTS Books");
            stat.executeUpdate("CREATE TABLE IF NOT EXISTS Books (id MEDIUMINT NOT NULL AUTO_INCREMENT, name CHAR(30) NOT NULL, PRIMARY KEY (id))");
            stat.executeUpdate("INSERT INTO Books (name) VALUES ('Inferno')", Statement.RETURN_GENERATED_KEYS);
            stat.executeUpdate("INSERT INTO Books (name) VALUES ('DaVinchi Code')", Statement.RETURN_GENERATED_KEYS);
            stat.executeUpdate("INSERT INTO Books (name) VALUES ('Solomon key')", Statement.RETURN_GENERATED_KEYS);

            Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            PreparedStatement preparedStatement = conn.prepareStatement("select * from Books", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet = statement.executeQuery("select * from Books");
            if(resultSet.next())
                System.out.println(resultSet.getString("name"));
            if(resultSet.next())
            System.out.println(resultSet.getString("name"));
            if(resultSet.previous())
                System.out.println(resultSet.getString("name"));
            if(resultSet.relative(1))
                System.out.println(resultSet.getString("name"));
            if(resultSet.relative(-1))
                System.out.println(resultSet.getString("name"));
            if(resultSet.absolute(3))
                System.out.println(resultSet.getString("name"));
            System.out.println(resultSet.getRow());
            resultSet.absolute(4);
            System.out.println(resultSet.getRow());
            if(resultSet.first())
                System.out.println("first");
            if(resultSet.last())
                System.out.println("last");
            System.out.println(resultSet.isFirst());
            System.out.println(resultSet.isLast());
        }
    }
}
