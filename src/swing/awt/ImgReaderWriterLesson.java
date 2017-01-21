package swing.awt;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.ImageOutputStream;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

public class ImgReaderWriterLesson {
    public static void main(String[] args) throws IOException {
        File file = new File("smile.jpg");
        BufferedImage image = ImageIO.read(file);
        ImageIO.write(image, "png", new File("smile.png"));

        ImageReader reader = null;
        Iterator<ImageReader> iterator = ImageIO.getImageReadersByFormatName("JPEG");
        if(iterator.hasNext()) reader = iterator.next();

        String[] extensions = ImageIO.getWriterFileSuffixes();
        for (String str : extensions) {
            System.out.println(str);
        }

        InputStream inputStream = new FileInputStream(new File("smile.jpg"));
        ImageInputStream imageInputStream = ImageIO.createImageInputStream(inputStream);
        ImageInputStream imageInputStream1 = ImageIO.createImageInputStream(new File("smile.jpg"));
        reader.setInput(imageInputStream, true);
        BufferedImage image1 = reader.read(reader.getNumImages(true));

        int count = reader.getNumThumbnails(0);
        BufferedImage image2 = reader.readThumbnail(0, count);
        System.out.println(reader.getHeight(0));
        reader.getWidth(0);

        ImageWriter writer = null;
        Iterator<ImageWriter> iterator1 = ImageIO.getImageWritersByFormatName("JPEG");
        if(iterator1.hasNext()) writer = iterator1.next();

        ImageOutputStream imageOutputStream = ImageIO.createImageOutputStream(new File("smile.png"));
        writer.setOutput(imageOutputStream);
    }
}
