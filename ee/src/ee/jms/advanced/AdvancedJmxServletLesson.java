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

@WebServlet("/advancedJmxLesson")
public class AdvancedJmxServletLesson extends HttpServlet {
    @Inject
//    @JMSSessionMode(JMSContext.AUTO_ACKNOWLEDGE)
    private JMSContext context;
    @Resource(name = "queue")
    private Queue queue;
    @Resource(name = "topic")
    private Topic topic;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        context.createProducer().setPriority(4).setTimeToLive(10000).setProperty("orderAmount", 1).send(queue, "Zero message");
        context.createProducer().setPriority(5).setTimeToLive(10000).setProperty("orderAmount", 0).setDeliveryMode(DeliveryMode.NON_PERSISTENT).send(queue, "First message");
        context.createProducer().setPriority(3).setTimeToLive(1).send(queue, "Second message");
        context.createProducer().setPriority(1).setTimeToLive(10000).send(queue, "Fourth message");
        context.createProducer().setPriority(2).setTimeToLive(10000).send(queue, "Third message");
//        JMSConsumer consumer = context.createConsumer(queue, "JMSPriority > 1 and orderAmount <> 1");
        JMSConsumer consumer = context.createConsumer(queue, "JMSPriority > 1");
        System.out.println(consumer.receiveBody(String.class));
        System.out.println(consumer.receiveBody(String.class));
        System.out.println(consumer.receiveBody(String.class));
//            System.out.println(context.createDurableConsumer(topic, "durableSubscription").receiveBody(String.class));
//            context.createConsumer(queue, "JMSPriority > 1 or orderAmount != 1").receive().acknowledge();
    }
}
