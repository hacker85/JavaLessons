package fx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Created by max on 3/1/17.
 */
public class LayoutLesson extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox hBox = new HBox();
        hBox.getChildren().addAll(new Button("one"), new Button("two"));
        hBox.setSpacing(5);
        hBox.setPadding(new Insets(5));

        Group root = new Group();
        root.getChildren().addAll(hBox);
        primaryStage.setScene(new Scene(root, 400, 300));
        primaryStage.show();
    }
}
