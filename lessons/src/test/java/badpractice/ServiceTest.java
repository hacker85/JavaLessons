package badpractice;

public class ServiceTest {
    void testLogIn() {
        Service service = new Service(new User(), 5);
    }
}
