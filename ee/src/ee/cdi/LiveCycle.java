package ee.cdi;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.interceptor.AroundConstruct;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LiveCycle")
public class LiveCycle extends HttpServlet {
    @Inject
    AroundInvokeClass aroundInvokeClass;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        aroundInvokeClass.doJob();
        aroundInvokeClass.doJob2();
        resp.getWriter().write("job done");
    }
}
@RequestScoped
class AroundInvokeClass {
    AroundInvokeClass() {
        System.out.println("constructor");
    }
    void doJob() {
        System.out.println("do job");
    }
    void doJob2() {
        System.out.println("do job2");
    }
    @AroundConstruct
    private void init() throws Exception {
        System.out.println("init");
    }
    @PostConstruct
    private void postConstruct() {
        System.out.println("post ocnstrcut");
    }
    @AroundInvoke
    private Object logMethod(InvocationContext context) throws Exception {
        System.out.println("log method");
        System.out.println(context.getMethod().getName());
        return context.proceed();
    }
    @PreDestroy
    private void preDestroy() {
        System.out.println("pre destroy");
    }
}