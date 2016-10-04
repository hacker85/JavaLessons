package properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by husiv on 10/4/16.
 */
public class PropertiesLesson {
    public static void main(String[] args) throws IOException {
        Properties defaultProperties = new Properties();
        defaultProperties.setProperty("height3", "default3");

        Properties properties = new Properties(defaultProperties);
//        properties.setProperty("width", "200");
//        FileOutputStream out = new FileOutputStream("program.properties");
//        properties.store(out, "My commets");
        FileInputStream in = new FileInputStream("program.properties");
        properties.load(in);
        System.out.println(properties.getProperty("height"));
        System.out.println(properties.getProperty("height2","default height2"));
        System.out.println(properties.getProperty("height3"));
        System.out.println(System.getProperty("user.home"));
    }
}
