package ee.ejb.beans;

import javax.annotation.PostConstruct;
import javax.ejb.DependsOn;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@DependsOn("DependsOnAndStartupBean2")
//@DependsOn("myJar.jar#DependsOnAndStartupBean2")
@Startup
public class DependsOnAndStartupBean1 {
    public void print() {
        System.out.println("hello world");
    }
    @PostConstruct
    void postConstruct() {
        System.out.println("postConctruct bean 2");
    }
}
