package fx;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by max on 3/3/17.
 */
public class CustomConstrolLesson extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
//        CustomControl customControl = new CustomControl();
//        customControl.setText("Hello!");

        NumberTextField customControl = new NumberTextField();

        Group group = new Group();
        group.getChildren().addAll(customControl);
        primaryStage.setScene(new Scene(group, 400, 300));
        primaryStage.show();
    }
}
