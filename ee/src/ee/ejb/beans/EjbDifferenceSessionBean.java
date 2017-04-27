package ee.ejb.beans;

import javax.ejb.Stateful;

@Stateful
public class EjbDifferenceSessionBean {
    int i;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}
