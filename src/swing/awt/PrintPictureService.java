package swing.awt;

import javax.print.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class PrintPictureService {
    public static void main(String[] args) throws FileNotFoundException, PrintException {
        DocFlavor flavor = DocFlavor.INPUT_STREAM.JPEG;
        PrintService[] services = PrintServiceLookup.lookupPrintServices(flavor, null);
        InputStream stream = new FileInputStream("smile.jpg");
        Doc doc = new SimpleDoc(stream,flavor,null);
        if (services.length > 0) {
            DocPrintJob job = services[0].createPrintJob();
            job.print(doc, null);
        }
    }
}
