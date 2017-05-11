package ee.jms.advanced;

import javax.ejb.MessageDriven;
import javax.jms.*;

@JMSConnectionFactoryDefinition(name = "MyFactory")
@JMSDestinationDefinition(name = "MyQueue",
        interfaceName = "javax.jms.Queue")
@MessageDriven(mappedName = "MyQueue")
public class DefinitionBean implements MessageListener {
    @Override
    public void onMessage(Message message) {
        try {
            System.out.println("Message received: " + message.getBody(String.class));
        } catch (JMSException e) {}
    }
}
