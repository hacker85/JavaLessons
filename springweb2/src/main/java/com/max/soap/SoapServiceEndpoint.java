package com.max.soap;

import javax.jws.WebService;

//@Component
@WebService(serviceName = "SoapService")
public class SoapServiceEndpoint {
//    @Autowired
//    SoapService soapService;
    public void printMessage(String s) {
//        soapService.printMessage(s);
    }
}
