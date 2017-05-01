package ee.ejb.beans;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.ejb.StatefulTimeout;

@Stateful
@StatefulTimeout(20)
//@Startup
public class EjbDifferenceSessionBean {
    int i;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    @Remove
    private void remove() {
        System.out.println("remove statefull bean");
    }
}
