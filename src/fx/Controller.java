package fx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
    }
    @FXML
    private void test(ActionEvent event)
    {
        System.out.println("lollolol");
    }
}