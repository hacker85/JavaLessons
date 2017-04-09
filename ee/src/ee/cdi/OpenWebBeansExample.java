package ee.cdi;

import org.apache.webbeans.config.WebBeansContext;
import org.apache.webbeans.spi.ContainerLifecycle;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;
import javax.inject.Named;

public class OpenWebBeansExample {
    public static void main(String[] args) {
        ContainerLifecycle lifecycle = WebBeansContext.getInstance().getService(ContainerLifecycle.class);
        lifecycle.startApplication(null);

        BeanManager beanManager = lifecycle.getBeanManager();
        Bean<?> bean = beanManager.getBeans("temp").iterator().next();

        Temp test = (Temp) lifecycle.getBeanManager().getReference(bean, Temp.class, beanManager.createCreationalContext(bean));
        test.doJob();

        lifecycle.stopApplication(null);
    }
}
@Named
class Temp {
    @Inject
    Test test;
    public void doJob() {
        test.doJob();
    }
}
@RequestScoped
class Test {
    public void doJob() {
        System.out.println("do job");
    }
}