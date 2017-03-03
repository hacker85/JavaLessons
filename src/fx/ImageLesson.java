package fx;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by max on 3/2/17.
 */
public class ImageLesson extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Image image = new Image(new FileInputStream("/home/max/IdeaProjects/JavaLessons/smile.jpg"));
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(300);
        imageView.setFitWidth(400);

        PixelReader pixelReader = image.getPixelReader();
        for (int readY = 0; readY < image.getHeight(); readY++) {
            for (int readX = 0; readX < image.getWidth(); readX++) {
                Color color = pixelReader.getColor(readX, readY);
            }
        }

        WritableImage wImage = new WritableImage((int)image.getWidth(),(int)image.getHeight());
        PixelWriter pixelWriter = wImage.getPixelWriter();
        for(int readY=0;readY<image.getHeight();readY++){
            for(int readX=0; readX<image.getWidth();readX++){
                pixelWriter.setColor(readX,readY,Color.ALICEBLUE);
            }
        }
        ImageView wImageView = new ImageView(wImage);
        wImageView.setFitHeight(300);
        wImageView.setFitWidth(400);
        ImageIO.write(SwingFXUtils.fromFXImage(wImage, null), "png", new FileOutputStream("test.png"));

        Group root = new Group();
        root.getChildren().addAll(imageView);
        primaryStage.setScene(new Scene(root, 400, 300));
        primaryStage.show();
    }
}
