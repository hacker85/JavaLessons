package com.max;

import com.max.config.JmxConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context = new AnnotationConfigApplicationContext(JmxConfig.class);

//        StudentAutoRepository bean = context.getBean(StudentAutoRepository.class);
//        Student max = bean.getStudentByName("Max");
//        System.out.println(max.getId());
//        bean.save(new Student("Max"));
//        StudentRepo bean = context.getBean(StudentRepo.class);
//        bean.saveStudent();
//        CarRepo bean = context.getBean(CarRepo.class);
//        bean.saveCar();
//        UserAutoRepository bean = context.getBean(UserAutoRepository.class);
//        User byId = bean.getById(3);
//        System.out.println(byId.getName());
//        User user = bean.getByName("Mike");
//        System.out.println(user.getId());
//        List<User> users = bean.findAll();
//        System.out.println(users.size());

//        UserRepo bean = context.getBean(UserRepo.class);
//        bean.saveUser(new User("Max"));
//        BookAutoRepository bean = context.getBean(BookAutoRepository.class);
//        bean.save(new Book("new"));
//        Book max = bean.findByNames("Max");
//        Book max = bean.getById(4);
//        System.out.println(max.getName());
//        System.out.println(max.getId());
//        UserRepo bean = context.getBean(UserRepo.class);
//        bean.saveUser(new User("Max"));
//        Repo bean = context.getBean(BookAutoRepository.class);
//        bean.createTable();


//        ApplicationContext context = new AnnotationConfigApplicationContext(DbConfig.class);
//        Car bean = context.getBean(Toyota.class);
//        bean.drive();
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
//        ApplicationContext context = new AnnotationConfigApplicationContext(com.max.config.AppConfig.class);

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
