package com.max;

import com.max.impl.Toyota;
import com.max.interfaces.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//        context.getEnvironment().setActiveProfiles("dev");
//        context.register(Config.class);
//        context.refresh();
//        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:config.xml");
//        ApplicationContext context = new AnnotationConfigWebApplicationContext();
//        ApplicationContext context = new FileSystemXmlApplicationContext("//home/max/IdeaProjects/JavaLessons/sprng/src/main/resources/config.xml");
//        ApplicationContext context = new XmlWebApplicationContext();
//        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
//        context.getEnvironment().setActiveProfiles("dev");
//        context.load("classpath*:config.xml");
//        context.refresh();
//        ApplicationContext context = new AnnotationConfigApplicationContext(com.max.AppConfig.class);
        ApplicationContext context = new AnnotationConfigApplicationContext(com.max.Config.class);
        Car bean = context.getBean(Toyota.class);
        bean.drive();

//        ExpressionParser parser = new SpelExpressionParser();
//        Expression exp = parser.parseExpression("'Hello World'");
//        String message = (String) exp.getValue();
//        System.out.println(message);

//        BestFm bestFm = new BestFm();
//        bestFm.setName("TestFm");
//        ExpressionParser parser2 = new SpelExpressionParser();
//        Expression exp2 = parser2.parseExpression("name");
//        EvaluationContext context2 = new StandardEvaluationContext(bestFm);
//        String name = (String) exp2.getValue(context2);
//        System.out.println(name);

//        System.out.println(bean.getRadio() == bean.getRadio());
//        ((ConfigurableApplicationContext)context).close();

//        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
//        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
//        reader.loadBeanDefinitions(new FileSystemResource("sprng/src/main/resources/config.xml"));
//        Toyota bean = factory.getBean(Toyota.class);
//        bean.drive();
    }
}
