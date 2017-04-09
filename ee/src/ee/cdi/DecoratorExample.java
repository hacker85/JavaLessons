package ee.cdi;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/decorator")
public class DecoratorExample extends HttpServlet {
    @Inject
    Origin origin;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        origin.doJob();
    }
}
interface Origin {
    void doJob();
}
class OriginImpl implements Origin {
    @Override
    public void doJob() {
        System.out.println("do job");
    }
}
@Decorator
class MyDecorator implements Origin {
    @Inject
    @Delegate
    private Origin origin;
    public void doJob() {
        System.out.println("decorator");
        origin.doJob();
    }
}