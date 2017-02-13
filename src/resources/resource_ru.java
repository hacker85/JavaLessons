package resources;

import java.awt.*;
import java.util.ListResourceBundle;

/**
 * Created by max on 2/13/17.
 */
public class resource_ru  extends ListResourceBundle {
    private static final Object[][] contents =
            {
                    { "somevalue" , "Это на русском языке"},
                    { "backgroundColor", Color.black },
                    { "defaultPaperSize", new double[] { 210, 297 } }
            };
    public Object[][] getContents() { return contents; }
}