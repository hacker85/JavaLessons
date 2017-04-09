package ee.cdi;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.interceptor.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/InterceptorClass")
public class InterceptorClass extends HttpServlet {
    @Inject
    Logger logger;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.print1();
        logger.print3();
    }
}
class MyInterceptor {
    @AroundConstruct
    private void init(InvocationContext context) throws Exception {
        System.out.println("init");
        context.proceed();
    }
    @PostConstruct
    private void postConstruct(InvocationContext context) {
        System.out.println("post ocnstrcut");
        try {
            context.proceed();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @AroundInvoke
    private Object around(InvocationContext context) throws Exception {
        System.out.println("around");
        return context.proceed();
    }
    @PreDestroy
    private void preDestroy(InvocationContext context) {
        System.out.println("pre destroy");
        try {
            context.proceed();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
@RequestScoped
@Interceptors(MyInterceptor.class)
class Logger {
    public Logger() {
        System.out.println("constructor");
    }

//    @Interceptors(MyInterceptor.class)
    void print1() {
        System.out.println("print 1");
    }
    void print2() {
        System.out.println("print 2");
    }
    @ExcludeClassInterceptors
    void print3() {
        System.out.println("print 3");
    }
}