package ee.jms.simplify;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/jmxContextServletProducer")
public class JmxContextServletProducer extends HttpServlet {
    @Inject
    @JMSConnectionFactory("MyJmsConnectionFactory")
//    @JMSPasswordCredential(userName="admin",password="mypassword")
    JMSContext context;
    @Resource(name = "queue")
    Queue queue;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        context.createProducer().send(queue, "Text message sent at " + new Date());
    }
}
