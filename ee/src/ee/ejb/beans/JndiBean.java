package ee.ejb.beans;

import javax.ejb.Stateless;

@Stateless
public class JndiBean {
    public String sayHello() {
        return "hello";
    }
}
