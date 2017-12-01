import com.max.test.Car;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@RunWith(SpringRunner.class)
//@ContextConfiguration(classes=TestConfig.class)
//@ActiveProfiles("default")
//@TestPropertySource("classpath:com/example/MyTest.properties")
//@TestPropertySource((properties = {"timezone = GMT", "port: 4242"}))
public class FirstTest {
    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    Car bean;

    @Test
    public void myTest() {
//        Car bean = applicationContext.getBean(Toyota.class);
        bean.drive();
    }

    @Configuration
    @ComponentScan(value = "com.max.test")
    static class TestConfig {}
}
