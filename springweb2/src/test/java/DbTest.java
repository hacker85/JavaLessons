import com.max.test.entities.User;
import com.max.test.interfaces.TestRepo;
import org.hibernate.SessionFactory;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.Properties;


//@WebAppConfiguration
@RunWith(SpringRunner.class)
@ContextConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DbTest {
    @Autowired
    TestRepo testRepo;
    @Test
    @Transactional//auto rollback
    @Commit
//    @Rollback
//    @Sql("/test-schema.sql")
    public void dbTest() {
        testRepo.saveUser(new User("Max"));
    }
    @Test
    @Transactional
    public void dbTest2() {
        System.out.println(testRepo.findUser().getName());
    }

    @Configuration
    @ComponentScan("com.max.test")
    @EnableTransactionManagement
    static class DbTestConfig {
        @Bean
        public DataSource dataSource() {
            DriverManagerDataSource ds = new DriverManagerDataSource();
            ds.setDriverClassName("com.mysql.jdbc.Driver");
            ds.setUrl("jdbc:mysql://localhost:3306/Lessons");
            ds.setUsername("root");
            ds.setPassword("1");
            return ds;
        }
        @Bean
        public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
            LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
            localSessionFactoryBean.setDataSource(dataSource);
            localSessionFactoryBean.setPackagesToScan(new String[] { "com.max.test.entities" });
            Properties props = new Properties();
            props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
            props.setProperty("hibernate.show_sql", "true");
            props.setProperty("hibernate.hbm2ddl.auto", "create-drop");
            localSessionFactoryBean.setHibernateProperties(props);
            return localSessionFactoryBean;
        }
        @Bean("myTransaction")
        public HibernateTransactionManager txManager(SessionFactory sessionFactory) {
            HibernateTransactionManager txManager = new HibernateTransactionManager();
            txManager.setSessionFactory(sessionFactory);
            return txManager;
        }
    }
}
