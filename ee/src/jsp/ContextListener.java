package jsp;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

//ServletContextListener
//ServletContextAttributeListener
//HttpSessionListener
//HttpSessionAttributeListener
//HttpSessionActivationListener
//HttpSessionBindingListener
//ServletRequestListener
//ServletRequestAttributeListener
public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("init context");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("destroy context");
    }
}
