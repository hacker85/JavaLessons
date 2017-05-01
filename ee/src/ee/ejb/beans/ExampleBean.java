package ee.ejb.beans;

import javax.ejb.Singleton;

@Singleton
public class ExampleBean {
    public String getName() {
        return "Max";
    }
}