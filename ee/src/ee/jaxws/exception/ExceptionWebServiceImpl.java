package ee.jaxws.exception;

import javax.jws.WebService;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.soap.SOAPFault;

@WebService(endpointInterface = "ee.jaxws.exception.ExceptionWebService")
public class ExceptionWebServiceImpl implements ExceptionWebService {
    public double divide(double a, double b) throws SOAPException {
        if(b == 0) {
//            throw new ValueIsNullException("value is null");
            SOAPFactory soapFactory = SOAPFactory.newInstance();
            SOAPFault fault = soapFactory.createFault("The second number is invalid", new QName("ValidationFault"));
            throw new ValueIsNullException(fault);
        } else {
            return a/b;
        }
    }
}