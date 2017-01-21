package swing.awt;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class ImgReaderWriterLesson {
    public static void main(String[] args) throws IOException {
        File file = new File("smile.jpg");
        if(file.exists()) {
            System.out.println("true");
        }
        BufferedImage image = ImageIO.read(file);
        ImageIO.write(image, "png", new File("smile.png"));

//        ImageReader reader = null;
//        Iterator<ImageReader> iterator = ImageIO.getImageReadersByFormatName("JPEG");
//        if(iterator.hasNext()) reader = iterator.next();
//
//        String[] extensions = ImageIO.getWriterFileSuffixes();
//        for (String str : extensions) {
//            System.out.println(str);
//        }
    }
}
