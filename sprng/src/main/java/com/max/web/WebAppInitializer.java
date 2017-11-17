package com.max.web;

public class WebAppInitializer {// extends AbstractAnnotationConfigDispatcherServletInitializer {
    protected Class<?>[] getRootConfigClasses() {
        return null;//new Class<?>[] { MyWebConfig.class };
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { MyWebConfig.class };
    }

    protected String[] getServletMappings() {
//        return new String[0];
        return new String[] { "/web/*" };
    }
}
