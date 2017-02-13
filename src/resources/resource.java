package resources;

import java.awt.*;
import java.util.ListResourceBundle;

/**
 * Created by max on 2/13/17.
 */
public class resource  extends ListResourceBundle {
    private static final Object[][] contents =
            {
                    { "somevalue" , "This is english Text"},
                    { "backgroundColor", Color.black },
                    { "defaultPaperSize", new double[] { 210, 297 } }
            };
    public Object[][] getContents() { return contents; }
}