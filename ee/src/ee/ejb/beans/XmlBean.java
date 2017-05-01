package ee.ejb.beans;

import javax.annotation.Resource;

public class XmlBean {
    @Resource(name = "currencyEntry")
    String currencyEntry;
    @Resource(name = "currencyRate")
    double currencyRate;
    public String sayHello() {
        return "Hello " + currencyEntry + " " + currencyRate;
    }
}
