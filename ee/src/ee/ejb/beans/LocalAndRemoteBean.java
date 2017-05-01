package ee.ejb.beans;

import ee.ejb.beans.interfaces.LocalBeanInteface;
import ee.ejb.beans.interfaces.RemoteBeanInterface;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
//@Local(LocalBeanInteface.class)
//@Remote(RemoteBeanInterface.class)
@LocalBean
public class LocalAndRemoteBean implements LocalBeanInteface, RemoteBeanInterface {
    @Override
    public String sayHello() {
        return "hello";
    }

    @Override
    public String sayRemoteHello() {
        return "remote hello";
    }

    public String sayLocalHello() {
        return "local hello";
    }
}
