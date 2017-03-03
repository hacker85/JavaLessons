package fx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Created by max on 3/2/17.
 */
public class FxmlLesson extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group group = new Group();
        Scene scene = new Scene(group, 400, 300);

        Parent content = FXMLLoader.load(getClass().getResource("form.fxml"));
        BorderPane root = new BorderPane();
        root.setCenter(content);
        group.getChildren().add(root);

        primaryStage.setTitle("Hello world!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
