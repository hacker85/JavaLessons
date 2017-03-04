package fx;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class CollectionsLesson {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();

        ObservableList<String> observableList = FXCollections.observableList(list);
        observableList.addListener(new ListChangeListener() {
            @Override
            public void onChanged(ListChangeListener.Change change) {
                System.out.println("Detected a change! ");
            }
        });
        observableList.add("item one");
        list.add("item two");

        System.out.println("Size: "+observableList.size());

    }
}
