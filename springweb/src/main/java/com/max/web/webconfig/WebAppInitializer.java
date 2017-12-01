package com.max.web.webconfig;

import com.max.web.config.MyWebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { MyWebConfig.class};
    }

    protected String[] getServletMappings() {
        return new String[] { "/spring/*" };
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        super.customizeRegistration(registration);
        registration.setMultipartConfig(new MultipartConfigElement("/tmp/app/uploads"));
//        registration.setMultipartConfig(new MultipartConfigElement("/tmp/app/uploads", 2097152, 4194304, 0));
    }
}
