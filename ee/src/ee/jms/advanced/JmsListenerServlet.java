package ee.jms.advanced;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/addJmsListener")
public class JmsListenerServlet extends HttpServlet {
    @Inject
    JMSContext context;
    @Resource(name = "queue")
    Queue queue;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        context.createProducer().send(queue, "Text message sent at " + new Date());
        context.createConsumer(queue).setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                try {
                    System.out.println("Async Message received: " + message.getBody(String.class));
                } catch (JMSException e) {}
            }
        });
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {}
    }
}