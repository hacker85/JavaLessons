package ee.jsf;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class InputBean {
    String myTextInput;

    public String getMyTextInput() {
        return myTextInput;
    }

    public void setMyTextInput(String myTextInput) {
        this.myTextInput = myTextInput;
    }

    public void printInput() {
        System.out.println(myTextInput);
    }
}
