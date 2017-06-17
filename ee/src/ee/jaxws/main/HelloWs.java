package ee.jaxws.main;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService(endpointInterface = "ee.jaxws.main.Hello")
public class HelloWs {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/HelloWs", new HelloWs());
    }
    public String print(String name) {
        return "Hello " + name;
    }
    public boolean checkStudent(Student student) {
        return student.avarageMark > 3;
    }
}
