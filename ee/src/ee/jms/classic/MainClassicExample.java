package ee.jms.classic;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.broker.BrokerFactory;
import org.apache.activemq.broker.BrokerService;

import javax.jms.*;
import java.net.URI;
import java.util.Date;

public class MainClassicExample {
    public static void main(String[] args) throws Exception {
        BrokerService broker = BrokerFactory.createBroker(new URI("broker:(tcp://localhost:61616)"));
        broker.start();
        Connection connection = null;
        try {
            // Producer
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
            connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Queue queue = session.createQueue("customerQueue");
            Message msg = session.createTextMessage("message was sent at: " + new Date());
            MessageProducer producer = session.createProducer(queue);
            producer.send(msg);

            // Consumer
            MessageConsumer consumer = session.createConsumer(queue);
//            consumer.setMessageListener(new MessageListener() {
//                @Override
//                public void onMessage(Message message) {
//                    TextMessage textMessage = (TextMessage) message;
//                    try {
//                        System.out.println("received " + textMessage.getText());
//                    } catch (JMSException e) {
//                        e.printStackTrace();
//                    }
//                }
//            });
            connection.start();

            TextMessage message = (TextMessage) consumer.receive();
            System.out.println(message.getText());
            Thread.sleep(500);
            session.close();
        } finally {
            if (connection != null) {
                connection.close();
            }
            broker.stop();
        }
    }
}
