package ee.jms.advanced;

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

@WebServlet("/connectionDefinitionServlet")
public class ConnectionFactoryDefinitionServletLesson extends HttpServlet {
    @Inject
    @JMSConnectionFactory("MyFactory")
    JMSContext context;
    @Resource(mappedName="MyQueue")
    Queue queue;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        context.createProducer().send(queue, "Text message sent at " + new Date());
    }
}
