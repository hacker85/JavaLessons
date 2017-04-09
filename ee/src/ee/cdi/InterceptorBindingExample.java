package ee.cdi;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InterceptorBinding;
import javax.interceptor.InvocationContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static javax.interceptor.Interceptor.Priority.APPLICATION;

@WebServlet("/interBind")
public class InterceptorBindingExample extends HttpServlet {
    @Inject
    BindService bindService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        bindService.doJob();
        bindService.doJob2();
    }
}
@InterceptorBinding
@Target({METHOD, TYPE})
@Retention(RUNTIME)
@interface Loggable { }

@Interceptor
@Loggable
@Priority(APPLICATION)
class LoggingInterceptor {
    @AroundInvoke
    public Object logMethod(InvocationContext context) throws Exception {
        System.out.println("pre invoce method");
        return context.proceed();
    }
}

@InterceptorBinding
@Target({METHOD, TYPE})
@Retention(RUNTIME)
@interface Loggable2 { }

@Interceptor
@Loggable2
@Priority(javax.interceptor.Interceptor.Priority.PLATFORM_BEFORE)
class LoggingInterceptor2 {
    @AroundInvoke
    public Object logMethod(InvocationContext context) throws Exception {
        System.out.println("pre invoce method2");
        return context.proceed();
    }
}

//@Loggable
class BindService {
    @Loggable
    @Loggable2
    public void doJob() {
        System.out.println("hello world");
    }
    public void doJob2() {
        System.out.println("hello world 2");
    }
}
