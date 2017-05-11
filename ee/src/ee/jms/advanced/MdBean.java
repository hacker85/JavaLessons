package ee.jms.advanced;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.*;
import java.util.Date;

@MessageDriven(mappedName = "queue", activationConfig = {
        @ActivationConfigProperty(propertyName = "acknowledgeMode",
                propertyValue = "Auto-acknowledge"),
//        @ActivationConfigProperty(propertyName = "messageSelector",
//                propertyValue = "orderAmount < 3000")
})
public class MdBean implements MessageListener {
    @Inject
    JMSContext context;
    @Resource(name = "queue")
    Queue queue;
    @Override
    public void onMessage(Message message) {
        try {
            System.out.println("Message received: " + message.getBody(String.class));
            Thread.sleep(100);
            context.createProducer().send(queue, "Text message sent at " + new Date());
        } catch (JMSException | InterruptedException e) {}
    }
}
