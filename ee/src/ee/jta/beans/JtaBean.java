package ee.jta.beans;

import javax.ejb.EJB;
import javax.ejb.Singleton;

@Singleton
public class JtaBean {
    @EJB
    PersistentBean persistentBean;
    public void saveBook() {
        persistentBean.saveBook();
    }
}
