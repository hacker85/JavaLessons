package ee.ejb;

import ee.ejb.beans.JndiBean;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;
import java.util.HashMap;
import java.util.Map;

public class MainLesson {
    public static void main(String[] args) throws NamingException {
        Map props = new HashMap();
        props.put ("org.glassfish.ejb.embedded.glassfish.installation.root", "/home/max/apps/glassfish4/glassfish/");
        try(EJBContainer container = EJBContainer.createEJBContainer(props)) {
            Context ctx = container.getContext();
            JndiBean jndiBean = (JndiBean)ctx.lookup("java:global/ee/JndiBean");
            System.out.println(jndiBean.sayHello());
        }
    }
}
