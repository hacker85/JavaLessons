import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Group group = new Group();
        primaryStage.setScene(new Scene(group, 400, 300));
        primaryStage.show();
    }

    @FXML
    public void print() {
        System.out.println("bla");
    }
}
