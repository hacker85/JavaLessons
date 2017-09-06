package ee.jsf;

import javax.faces.bean.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class BackingBean {
    private String someValue = "some value";

    public String getSomeValue() {
        return someValue;
    }

    public void setSomeValue(String someValue) {
        this.someValue = someValue;
    }

    public void doJob() {
        System.out.println("do job");
    }
}
