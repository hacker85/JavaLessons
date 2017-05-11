package ee.jms.classic;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/jmsClassicProducerServlet")
public class ProducerServlet extends HttpServlet {
//    @Resource(name = "topic")
//    private Topic topic;
//    @Resource(name = "queue")//(loockup = "openejb:Resource/FooQueue")
//    private Queue queue;
//    @Resource//(loockup = "openejb:Resource/MyJmsConnectionFactory")
//    ConnectionFactory connectionFactory;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Context jndiContext = new InitialContext();

            ConnectionFactory connectionFactory = (ConnectionFactory) jndiContext.lookup("openejb:Resource/MyJmsConnectionFactory");
            Queue queue = (Queue) jndiContext.lookup("openejb:Resource/FooQueue");

            Connection connection = connectionFactory.createConnection();
            connection.start();

            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            MessageProducer producer = session.createProducer(queue);
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

            TextMessage message = session.createTextMessage("Hello World!");

            producer.send(message);
        } catch (JMSException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}
