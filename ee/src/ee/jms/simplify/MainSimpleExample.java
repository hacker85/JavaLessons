package ee.jms.simplify;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.broker.BrokerFactory;
import org.apache.activemq.broker.BrokerService;

import javax.jms.*;
import java.net.URI;
import java.util.Date;

public class MainSimpleExample {
    public static void main(String[] args) throws Exception {
        BrokerService broker = BrokerFactory.createBroker(new URI("broker:(tcp://localhost:61616)"));
        broker.start();
        try {
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
            try (JMSContext context = connectionFactory.createContext()) {
                Queue queue = context.createQueue("queue");
                context.createProducer().send(queue, "Text message sent at " + new Date());
                String message = context.createConsumer(queue).receiveBody(String.class);
                System.out.println(message);
            }
            Thread.sleep(500);
        } finally {
            broker.stop();
        }
    }
}
