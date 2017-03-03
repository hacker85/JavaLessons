package fx;

import javafx.beans.binding.IntegerBinding;
import javafx.beans.property.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 * Created by max on 3/1/17.
 */
public class BindingLesson {
    public static void main(String[] args) {
        IntegerProperty integerProperty = new SimpleIntegerProperty(5);
        IntegerProperty integerProperty2 = new ReadOnlyIntegerWrapper(5);

        IntegerBinding integerBinding = new IntegerBinding() {
            {
                super.bind(integerProperty, integerProperty2);
            }
            @Override
            protected int computeValue() {
                return integerProperty.get() + integerProperty2.get();
            }
        };
        System.out.println(integerBinding.get());
        integerProperty.set(1);
        System.out.println(integerBinding.get());


        System.out.println(integerProperty.add(integerProperty2).getValue());


        integerProperty.addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println("new value = " + newValue);
            }
        });

        integerProperty.bindBidirectional(integerProperty2);
        integerProperty2.set(6);
        //System.out.println(integerProperty.get());
        integerProperty.set(7);
        //System.out.println(integerProperty2.get());
    }
}

class User {
    SimpleStringProperty userName = new SimpleStringProperty("Max");

    User() {
        userName.addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                System.out.println("new value: " + newValue);
            }
        });
    }

    public String getUserName() {
        return userName.get();
    }

    public SimpleStringProperty userNameProperty() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName.set(userName);
    }
}