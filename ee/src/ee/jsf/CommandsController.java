package ee.jsf;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class CommandsController {
    public void sayHello() {
        System.out.println("hello world");
    }
    public void printMessage(String myInput) {
        System.out.println("you print: " + myInput);
    }
}
