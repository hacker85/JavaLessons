package com.max.config;

//@Configuration
//@EnableJms
public class JmsConfig {
//    @Bean
//    public ActiveMQConnectionFactory activeMQConnectionFactory() {
//        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
////        activeMQConnectionFactory.setBrokerURL("tcp://localhost:61616");
//        return activeMQConnectionFactory;
//    }
//    @Bean
//    public ActiveMQQueue activeMQQueue() {
//        ActiveMQQueue activeMQQueue = new ActiveMQQueue();
//        activeMQQueue.setPhysicalName("queueName");
//        return activeMQQueue;
//    }
////    @Bean
////    public ActiveMQTopic activeMQTopic() {
////        ActiveMQTopic activeMQTopic = new ActiveMQTopic();
////        activeMQTopic.setPhysicalName("topicName");
////        return activeMQTopic;
////    }
//    @Bean
//    public JmsTemplate jmsTemplate(ActiveMQConnectionFactory connectionFactory) {
//        JmsTemplate jmsTemplate = new JmsTemplate();
//        jmsTemplate.setConnectionFactory(connectionFactory);
//        jmsTemplate.setDefaultDestinationName("queueName");
//        return jmsTemplate;
//    }
//
//    @Bean
//    public MessageConverter messageConverter() {
//        return new MappingJackson2MessageConverter();
//    }
//
//    @Bean("myFactory")
//    JmsListenerContainerFactory<?> myFactory(ConnectionFactory connectionFactory) {
//        DefaultJmsListenerContainerFactory listenerContainerFactory = new DefaultJmsListenerContainerFactory();
//        listenerContainerFactory.setConnectionFactory(connectionFactory);
//        return listenerContainerFactory;
//    }

//    @Bean
//    JmsInvokerServiceExporter jmsInvokerServiceExporter() {
//        JmsInvokerServiceExporter jmsInvokerServiceExporter = new JmsInvokerServiceExporter();
//        jmsInvokerServiceExporter.setMessageConverter(messageConverter());
//        jmsInvokerServiceExporter.setServiceInterface(JmsService.class);
//        return jmsInvokerServiceExporter;
//    }
}
