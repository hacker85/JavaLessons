package fx;

import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import javax.swing.*;

/**
 * Created by max on 3/4/17.
 */
public class SwingFxLesson {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Swing and JavaFX");
        JFXPanel fxPanel = new JFXPanel();
        frame.add(fxPanel);
        frame.setSize(300, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Group  root  =  new Group();
        Scene  scene  =  new  Scene(root, Color.ALICEBLUE);

        Text text  =  new  Text();
        text.setX(40);
        text.setY(100);
        text.setFont(new Font(25));
        text.setText("Welcome JavaFX!");

        root.getChildren().add(text);

        fxPanel.setScene(scene);
    }
}
