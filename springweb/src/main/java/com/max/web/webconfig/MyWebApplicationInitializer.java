package com.max.web.webconfig;

import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class MyWebApplicationInitializer {//} implements WebApplicationInitializer {
    public void onStartup(ServletContext servletContext) throws ServletException {;
//        ServletRegistration.Dynamic myServlet = servletContext.addServlet("myservlet", MyServlet.class);
//        myServlet.addMapping("/myservlet/*");
//        FilterRegistration.Dynamic filter = servletContext.addFilter("myFilter", MyFilter.class);
//        filter.addMappingForUrlPatterns(null, false, "/custom/*");

//        AnnotationConfigWebApplicationContext cxt = new AnnotationConfigWebApplicationContext();
//        cxt.register(MyWebConfig.class);
//        cxt.refresh();
        XmlWebApplicationContext cxt = new XmlWebApplicationContext();
        cxt.setConfigLocation("/WEB-INF/helloSpring-servlet.xml");

        DispatcherServlet servlet = new DispatcherServlet(cxt);

        ServletRegistration.Dynamic registration = servletContext.addServlet("app", servlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/app/*");
//        registration.setMultipartConfig(new MultipartConfigElement("/tmp/app/uploads"));
    }
}
