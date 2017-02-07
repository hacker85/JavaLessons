package jdbc;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.*;
import java.util.Scanner;

/**
 * Created by max on 2/7/17.
 */
public class BlobLesson {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        String url = "jdbc:mysql://localhost:3306/Lessons";
        String username = "root";
        String password = "1";
        Class.forName("com.mysql.jdbc.Driver");
        try(Connection conn = DriverManager.getConnection(url, username, password);
            Statement stat = conn.createStatement()) {
            stat.execute("drop table IF EXISTS Books");
            stat.executeUpdate("CREATE TABLE IF NOT EXISTS Books (id MEDIUMINT NOT NULL AUTO_INCREMENT, name CHAR(30) NOT NULL, img BLOB, PRIMARY KEY (id))");

            BufferedImage img = ImageIO.read(new File("smile.jpg"));
            Blob blb = conn.createBlob();
            try (OutputStream out = blb.setBinaryStream(1)) {
                ImageIO.write(img, "jpg", out);
            }

            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO Books (name, img) VALUES (?, ?)");
            preparedStatement.setString(1, "Inferno");
            preparedStatement.setBlob(2, blb);
            preparedStatement.executeUpdate();

            ResultSet result = stat.executeQuery("select * from Books");
            if (result.next())
            {
                Blob blob = result.getBlob("img");
                BufferedImage image = ImageIO.read(blob.getBinaryStream());
                File outputFile = new File("saved.png");
                ImageIO.write(image, "png", outputFile);
            }
        }

    }
}
