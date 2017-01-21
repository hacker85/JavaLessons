package swing.awt;

import javax.imageio.ImageIO;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.io.File;
import java.io.IOException;

public class ImgFilterLesson {
    public static void main(String[] args) throws IOException {
        File file = new File("smile.jpg");
        BufferedImage image = ImageIO.read(file);

        BufferedImage imageFiltered = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
        AffineTransform transform = AffineTransform.getRotateInstance(45, image.getWidth() / 2, image.getHeight() / 2);
        BufferedImageOp op = new AffineTransformOp(transform, AffineTransformOp.TYPE_BILINEAR);
        op.filter(image, imageFiltered);

        ImageIO.write(imageFiltered, "png", new File("smile.png"));
    }
}
