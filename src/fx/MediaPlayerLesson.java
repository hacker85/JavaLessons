package fx;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

/**
 * Created by max on 3/3/17.
 */
public class MediaPlayerLesson extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

//        Media media = new Media("file:///home/max/Downloads/sound.mp3");
        Media media = new Media("file:///mnt/788051CF8051950A/MyJavaVideoLessons/avi/101Swing6WindowLisener.mp4");
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        //mediaPlayer.setAutoPlay(true);
        MediaView mediaView = new MediaView(mediaPlayer);
        mediaPlayer.play();


        Group group = new Group();
        group.getChildren().add(mediaView);
        primaryStage.setScene(new Scene(group, 400, 300));
        primaryStage.show();
    }
}