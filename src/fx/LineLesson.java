package fx;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 * Created by max on 3/1/17.
 */
public class LineLesson extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Line line = new Line(50, 50, 100, 50);
        line.setStroke(Color.GREEN);

        Group group = new Group();
        group.getChildren().add(line);
        Scene scene = new Scene(group);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
