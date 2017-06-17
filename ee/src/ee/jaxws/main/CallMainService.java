package ee.jaxws.main;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;

public class CallMainService {
    //wsimport -keep http://localhost:8080/HelloWs?wsdl
    public static void main(String[] args) throws Exception {

        URL url = new URL("http://localhost:8080/HelloWs?wsdl");

        QName qname = new QName("http://main.jaxws.ee/", "HelloWsService");

        Service service = Service.create(url, qname);

        Hello hello = service.getPort(Hello.class);
        System.out.println(hello.print("Max"));
        System.out.println(hello.checkStudent(new Student(3)));
    }
}
