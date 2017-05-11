package ee.jms.simplify;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/jmxContextServletConsumer")
public class JmsContextServletConsumer extends HttpServlet {
    @Inject
    private JMSContext context;
    @Resource(name = "queue")
    private Queue queue;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String message = context.createConsumer(queue).receiveBody(String.class);
            System.out.println(message);
    }
}
