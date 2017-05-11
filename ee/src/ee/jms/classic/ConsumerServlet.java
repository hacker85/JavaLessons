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

@WebServlet(value = "/jmsClassicConsumerServlet")
public class ConsumerServlet extends HttpServlet {
//    @Resource(name = "topic")
//    private Topic topic;
//    @Resource(name = "queue")
//    private Queue queue;
//    @Resource
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

            MessageConsumer consumer = session.createConsumer(queue);

            connection.start();
            TextMessage message = (TextMessage) consumer.receive();
            System.out.println("Message received: " + message.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}
