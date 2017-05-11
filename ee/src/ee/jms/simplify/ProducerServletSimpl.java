package ee.jms.simplify;

import javax.annotation.Resource;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.jms.Topic;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/producerServlSimpl")
public class ProducerServletSimpl extends HttpServlet {
    @Resource(name = "topic")
    private Topic topic;
    @Resource(name = "queue")
    private Queue queue;
    @Resource
    ConnectionFactory connectionFactory;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (JMSContext context = connectionFactory.createContext()) {
            context.createProducer().send(queue, "Text message sent at " + new Date());
        }
    }
}
