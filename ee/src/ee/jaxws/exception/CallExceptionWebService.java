package ee.jaxws.exception;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;

public class CallExceptionWebService {
    public static void main(String[] args) throws Exception {

        URL url = new URL("http://localhost:8080/ExceptionWs?wsdl");

        QName qname = new QName("http://exception.jaxws.ee/", "ExceptionWebServiceImplService");

        Service service = Service.create(url, qname);

        ExceptionWebService exceptionWebService = service.getPort(ExceptionWebService.class);
        System.out.println(exceptionWebService.divide(5, 0));
    }
}
