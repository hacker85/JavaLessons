package com.max.web.config;

//@Configuration
//@EnableTransactionManagement
public class HiberConfig {
//    @Bean
//    public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
//        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
//        localSessionFactoryBean.setDataSource(dataSource);
//        localSessionFactoryBean.setPackagesToScan(new String[] { "com.max.web.entities" });
//        Properties props = new Properties();
//        props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
//        props.setProperty("hibernate.show_sql", "true");
//        props.setProperty("hibernate.hbm2ddl.auto", "create-drop");
//        localSessionFactoryBean.setHibernateProperties(props);
//        return localSessionFactoryBean;
//    }
//    @Bean("myTransaction")
//    public HibernateTransactionManager txManager(SessionFactory sessionFactory) {
//        HibernateTransactionManager txManager = new HibernateTransactionManager();
//        txManager.setSessionFactory(sessionFactory);
//        return txManager;
//    }
}
