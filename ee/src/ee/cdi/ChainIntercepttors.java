package ee.cdi;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptors;
import javax.interceptor.InvocationContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/chainInter")
public class ChainIntercepttors extends HttpServlet {
    @Inject
    InterService interService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        interService.doJob();
    }
}
class InterOne {
    @AroundInvoke
    private Object around(InvocationContext context) throws Exception {
        System.out.println("one");
        return context.proceed();
    }
}
class InterTwo {
    @AroundInvoke
    private Object around(InvocationContext context) throws Exception {
        System.out.println("two");
        return context.proceed();
    }
}
class InterThree {
    @AroundInvoke
    private Object around(InvocationContext context) throws Exception {
        System.out.println("three");
        return context.proceed();
    }
}
class InterFour {
    @AroundInvoke
    private Object around(InvocationContext context) throws Exception {
        System.out.println("four");
        return context.proceed();
    }
}
@Interceptors({InterOne.class,InterTwo.class})
class InterService {
    @Interceptors({InterThree.class, InterFour.class})
    public void doJob() {
        System.out.println("hello");
    }
}
