import com.max.test.Car;
import com.max.test.TestConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
//@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=TestConfig.class)
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
}
