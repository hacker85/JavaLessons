package internationalization;

import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by max on 2/13/17.
 */
public class BandleLesson {
    public static void main(String[] args) throws UnsupportedEncodingException {
        ResourceBundle bundleDefault = ResourceBundle.getBundle("logging");
        ResourceBundle bundleDe = ResourceBundle.getBundle("logging", Locale.GERMAN);
        ResourceBundle bundleRu = ResourceBundle.getBundle("logging", new Locale("ru", "RU"));
        System.out.println(bundleDefault.getString("readingFile"));
        System.out.println(bundleDe.getString("readingFile"));
        System.out.println(new String(bundleRu.getString("readingFile").getBytes("ISO-8859-1"), "UTF-8" ));

        ResourceBundle bundleClassDefault = ResourceBundle.getBundle("internationalization.resources.ClassLogging");
        ResourceBundle bundleClassDe = ResourceBundle.getBundle("internationalization.resources.ClassLogging", Locale.GERMAN);
        ResourceBundle bundleClassRu = ResourceBundle.getBundle("internationalization.resources.ClassLogging", new Locale("ru", "RU"));
        System.out.println(bundleDefault.getString("readingFile"));
        System.out.println(bundleDe.getString("readingFile"));
        System.out.println(new String(bundleRu.getString("readingFile").getBytes("ISO-8859-1"), "UTF-8" ));
    }
}
