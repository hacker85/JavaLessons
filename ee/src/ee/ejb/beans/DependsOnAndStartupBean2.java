package ee.ejb.beans;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

@Singleton
public class DependsOnAndStartupBean2 {
    @PostConstruct
    void postConstruct() {
        System.out.println("postConctruct bean 1");
    }
}
