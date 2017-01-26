package swing.awt;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageTransferLesson {
    public static void main(String[] args) throws InterruptedException, IOException, UnsupportedFlavorException {
        Image image = new BufferedImage(300, 300, BufferedImage.TYPE_INT_ARGB);
        Graphics g = image.getGraphics();
        g.fillOval(0,0, 100,100);

        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        ImageTransferable selection = new ImageTransferable(image);
        clipboard.setContents(selection, null);

        DataFlavor flavor = DataFlavor.imageFlavor;
        if (clipboard.isDataFlavorAvailable(flavor)) {
            image = (Image) clipboard.getData(flavor);
        }
    }
}

class ImageTransferable implements Transferable
{
    private Image theImage;
    public ImageTransferable(Image image)
    {
        theImage = image;
    }
    public DataFlavor[] getTransferDataFlavors()
    {
        //"application/x-java-serialized-object;class=" + type.getName()
        return new DataFlavor[] { DataFlavor.imageFlavor };
    }
    public boolean isDataFlavorSupported(DataFlavor flavor)
    {
        return flavor.equals(DataFlavor.imageFlavor);
    }
    public Object getTransferData(DataFlavor flavor)
            throws UnsupportedFlavorException
    {
        if(flavor.equals(DataFlavor.imageFlavor))
        {
            return theImage;
        }
        else
        {
            throw new UnsupportedFlavorException(flavor);
        }
    }
}
