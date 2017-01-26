package swing.awt;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class ClipboardStringLesson {
    public static void main(String[] args) throws IOException, UnsupportedFlavorException, InterruptedException {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection stringSelection = new StringSelection("text");
        clipboard.setContents(stringSelection, null);

        Thread.sleep(1000000);

        //application/x-java-serialized-object;class=java.lang.String
        DataFlavor flavor = DataFlavor.stringFlavor;
        if (clipboard.isDataFlavorAvailable(flavor)) {
            System.out.println(clipboard.getData(flavor));
        }
    }
}
