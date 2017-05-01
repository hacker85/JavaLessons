package ee.ejb.beans;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Singleton;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.ws.WebServiceRef;

@Singleton
public class SessionContextDIBean {
    @PersistenceContext
    private EntityManager em;
    @EJB
    private ExampleBean exampleBean;
    @Inject
    private RequestScope requestScope;
    @WebServiceRef
    private MyWebService myWebService;
    @Resource
    private SessionContext context;

    public void doJob() {
        if(!context.getRollbackOnly()) {
//            UserTransaction userTransaction = context.getUserTransaction();
            if(context.isCallerInRole("max")) {
                requestScope.sayHello();
            } else {
                System.out.println("no permission");
            }
            context.setRollbackOnly();
        }
    }

}
@RequestScoped
class RequestScope {
    public void sayHello() {
        System.out.println("hello");
    }
}
@WebService
class MyWebService {

}