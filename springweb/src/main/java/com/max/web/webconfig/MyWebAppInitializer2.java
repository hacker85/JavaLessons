package com.max.web.webconfig;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

public class MyWebAppInitializer2 {//} extends AbstractDispatcherServletInitializer {
    protected WebApplicationContext createRootApplicationContext() {
        return null;
    }
    protected WebApplicationContext createServletApplicationContext() {
        XmlWebApplicationContext cxt = new XmlWebApplicationContext();
        cxt.setConfigLocation("/WEB-INF/helloSpring-servlet.xml");
        return cxt;
    }
    protected String[] getServletMappings() {
        return new String[] { "/qwe/*" };
    }
}