package swing.awt;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

public class ImgRasterLesson {
    public static void main(String[] args) throws IOException {
        File file = new File("smile.jpg");
        BufferedImage image = ImageIO.read(file);

        WritableRaster writableRaster = image.getRaster();
        for (int i = 0; i < image.getWidth(); i++) {
            int[] pixel = writableRaster.getPixel(i,0, new int[4]);
            pixel[0] = 0;
            pixel[1] = 0;
            pixel[2] = 0;
            writableRaster.setPixel(i,0, pixel);
        }

        writableRaster.getPixels(0,0, image.getHeight(), image.getWidth(), new int[4 * image.getHeight() * image.getWidth()]);
        writableRaster.setPixels(0,0,image.getHeight(),image.getWidth(),new int[4 * image.getHeight() * image.getWidth()]);

        Object data = writableRaster.getDataElements(0,0, null);
        ColorModel colorModel = image.getColorModel();
        Color color = new Color(colorModel.getRGB(data),true);
        writableRaster.setDataElements(0,0, data);

        image.setData(writableRaster);

        ImageIO.write(image, "png", new File("smile.png"));
    }
}
