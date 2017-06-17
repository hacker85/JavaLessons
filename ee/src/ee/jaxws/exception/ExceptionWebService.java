package ee.jaxws.exception;

import javax.jws.WebService;
import javax.xml.soap.SOAPException;

@WebService
public interface ExceptionWebService {
    double divide(double a, double b) throws SOAPException;
}
