package swing.web;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

/**
 * Created by husiv on 10/4/16.
 */
public class PreferencesLesson {
    public static void main(String[] args) throws IOException, BackingStoreException {
        Preferences root = Preferences.userRoot();
        Preferences systemRoot = Preferences.systemRoot();
        Preferences node = root.node("/com/max/lessons");
        Preferences node2 = root.userNodeForPackage(new PreferencesLesson().getClass());
        node.put("myInt", "2");
        System.out.println(node.getInt("myInt", 1));
        root.exportSubtree(new FileOutputStream("prop.xml"));
    }
}
