package ee.ejb.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.*;

@Stateful//(passivationCapable=false)
public class LiveCycleBean {
    public String getName() {
        return "Max";
    }
    @PostConstruct
    void postConstruct() {
        System.out.println("postConstruct");
    }
    @PreDestroy
    void preDestroy() {
        System.out.println("preDestroy");
    }
    @PostActivate
    void postCativate() {
        System.out.println("postActivate");
    }
    @PrePassivate
    void prePassivate() {
        System.out.println("prePassivate");
    }
    @Remove
    void remove() {
        System.out.println("remove");
    }
}
