package fx;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Created by max on 3/1/17.
 */
public class ShapesLesson extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

//   Arc
//   Circle
//	 CubicCurve
//	 Ellipse
//	 Line
//	 Path
//   Polygon
//	 Polyline
//	 QuadCurve
//	 Rectangle
//	 SVGPath
//	 Text (which is considered to be a type of shape)
    @Override
    public void start(Stage primaryStage) throws Exception {
        Line line = new Line(50, 50, 100, 50);
        line.setStroke(Color.GREEN);
        Text text = new Text(0,50,"hello");
        text.setFont(Font.font(50));
        text.setStroke(Color.BLACK);

        Group group = new Group();
        group.getChildren().add(line);
        group.getChildren().add(text);
        Scene scene = new Scene(group);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
