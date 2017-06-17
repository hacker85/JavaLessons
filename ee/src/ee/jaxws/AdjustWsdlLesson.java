package ee.jaxws;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.WebServiceContext;

import static javax.jws.soap.SOAPBinding.Style.RPC;
import static javax.jws.soap.SOAPBinding.Use.LITERAL;

@WebService(serviceName = "wsdlAdjustService", portName = "adjustPort")
@SOAPBinding(style = RPC, use = LITERAL)
public class AdjustWsdlLesson {
    @Resource
    WebServiceContext context;
    @WebMethod(operationName = "addDigits", exclude = false)
    @WebResult(name = "addResult")
    public int add(int a, int b) {
        return a + b;
    }
}
