package fx;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * Created by max on 3/2/17.
 */
public class CssStyleLesson extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //AquaFx.style();
//        Application.setUserAgentStylesheet(STYLESHEET_CASPIAN);
//        Application.setUserAgentStylesheet(STYLESHEET_MODENA);
//        Application.setUserAgentStylesheet(getClass().getResource("sample.css").toExternalForm());


        Button button = new Button("press");
        button.getStyleClass().add("test");
        button.setStyle("-fx-background-color: blue");

        Label label = new Label("test");

        Group group = new Group();
        Scene scene = new Scene(group, 400, 300);

        scene.getStylesheets().add(getClass().getResource("sample.css").toExternalForm());

        group.getChildren().add(button);
        group.getChildren().add(label);

        primaryStage.setTitle("Hello world!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}