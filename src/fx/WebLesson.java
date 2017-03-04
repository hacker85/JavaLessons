package fx;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import netscape.javascript.JSObject;
import org.w3c.dom.Document;

import static javafx.concurrent.Worker.State.SUCCEEDED;

/**
 * Created by max on 3/3/17.
 */
public class WebLesson extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();
        //webEngine.load();
        Document dom = webEngine.getDocument();
        webEngine.loadContent("<div id=\"div\" style=\"color: red\">text</div><script>document.getElementById(\"div\").style.color=\"blue\";" +
                "function changeColor(){" +
                "var message = hello.sayGoodbye(\"Max\");" +
                "document.getElementById(\"div\").innerHTML = message;" +
                "document.getElementById(\"div\").style.color=\"green\"" +
                "};" +
                "</script>");
        JSObject jsObject = (JSObject) webEngine.executeScript("window");
        jsObject.setMember("hello", new MyHelloWorld());
        webEngine.getLoadWorker()
                .stateProperty()
                .addListener( (obs, oldValue, newValue) -> {
                    if (newValue == SUCCEEDED) {
                        webEngine.executeScript("changeColor();");
                    }
                });

        Group group = new Group();
        group.getChildren().add(webView);
        primaryStage.setScene(new Scene(group, 400, 300));
        primaryStage.show();
    }

    public class MyHelloWorld {
        public String sayGoodbye(String name) {
            return "Hello " + name;
        }
    }
}
