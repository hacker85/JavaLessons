package com.max.soap;

import javax.jws.WebService;

@WebService(serviceName = "SoapService")
public interface SoapService {
    void printMessage(String s);
}
