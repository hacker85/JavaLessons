package com.max.impl;

import com.max.entities.User;
import com.max.interfaces.JmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsOperations;

//@Component
public class JmsServiceImpl implements JmsService {
    @Autowired
    JmsOperations jmsOperations;
    public void sendMessage(final User user) {
//        jmsOperations.send("queueName",new MessageCreator() {
//            public Message createMessage(Session session) throws JMSException {
//                return session.createObjectMessage(user);
//            }
//        });
        jmsOperations.convertAndSend(user);
    }
    public User receiveMessage() {
//        try {
//            ObjectMessage receivedMessage = (ObjectMessage) jmsOperations.receive();
//            return (User) receivedMessage.getObject();
//        } catch (JMSException jmsException) {
//            throw JmsUtils.convertJmsAccessException(jmsException);
//        }
        return (User) jmsOperations.receiveAndConvert();
    }

    @JmsListener(destination = "queueName", containerFactory = "myFactory")
    public void listen(User user) {
        System.out.println(user.getName());
    }
}
