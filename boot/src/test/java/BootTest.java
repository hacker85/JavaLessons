import com.max.interfaces.MyComponent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BootTest.Config.class)
//@TestConfiguration
public class BootTest {
    @Autowired
//    @MockBean
    MyComponent bean;
    @Test
    public void test() {
        bean.print();
    }
    @SpringBootConfiguration
    @ComponentScan("com.max")
    static class Config {}
}
