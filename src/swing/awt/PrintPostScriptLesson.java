package swing.awt;

import javax.print.*;
import java.io.*;

public class PrintPostScriptLesson {
    public static void main(String[] args) throws FileNotFoundException, PrintException {
        DocFlavor flavor = DocFlavor.SERVICE_FORMATTED.PRINTABLE;
        String mimeType = "application/postscript";
        StreamPrintServiceFactory[] factories = StreamPrintServiceFactory.lookupStreamPrintServiceFactories(flavor, mimeType);
        OutputStream outStream = new FileOutputStream("PostService.odd");
        StreamPrintService streamPrintService = factories[0].getPrintService(outStream);

        InputStream inStream = new FileInputStream("smile.jpg");
        DocPrintJob job = streamPrintService.createPrintJob();
        Doc doc = new SimpleDoc(inStream, DocFlavor.INPUT_STREAM.JPEG,null);
        job.print(doc, null);
    }
}
