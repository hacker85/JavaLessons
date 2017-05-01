package ee.ejb.beans;

import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Singleton;
import java.util.concurrent.atomic.AtomicInteger;

@Singleton
//@Lock(LockType.WRITE)
//@AccessTimeout(value = 20, unit = TimeUnit.SECONDS)
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
public class ConcurencyBean {
//    int i;
    AtomicInteger atomicInteger = new AtomicInteger(0);

//    @Lock(LockType.READ)
//@AccessTimeout(0)
//@AccessTimeout(-1)
//@AccessTimeout(5)
//    public synchronized int increseAndGetI() {
    public int increseAndGetI() {
//        return ++i;
        return atomicInteger.addAndGet(1);
    }

//    public int getI() {
//        return i;
//    }
//
//    public int setI(int i) {
//        this.i = i;
//        return i;
//    }
}
