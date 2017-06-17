package ee.jaxws.exception;

import javax.xml.soap.SOAPFault;
import javax.xml.ws.WebFault;
import javax.xml.ws.soap.SOAPFaultException;

@WebFault(name = "ValueIsWrong")
class ValueIsNullException extends SOAPFaultException {// Exception {
//    public ValueIsNullException() {
//        super();
//    }
//
//    public ValueIsNullException(String message) {
//        super(message);
//    }

    public ValueIsNullException(SOAPFault fault) {
        super(fault);
    }
}
