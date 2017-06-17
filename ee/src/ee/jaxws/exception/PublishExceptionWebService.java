package ee.jaxws.exception;

import javax.xml.ws.Endpoint;

public class PublishExceptionWebService {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/ExceptionWs", new ExceptionWebServiceImpl());
    }
}
