package ee.ejb;

import ee.ejb.beans.JndiBean;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/jndiNameLesson")
public class JNDINameLesson extends HttpServlet {
    @Resource(lookup = "java:module/JndiBean")
    JndiBean jndiBean;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        try {
//            InitialContext context = new InitialContext();
////            java:<scope>[/<app-name>]/<module-name>/<bean-name>[!<fully-qualified-interface-name>]
//            JndiBean jndiBean = (JndiBean)context.lookup("java:module/JndiBean");
//            resp.getWriter().write(jndiBean.sayHello());
//        } catch (NamingException e) {
//            e.printStackTrace();
//        }
        resp.getWriter().write(jndiBean.sayHello());
    }
}
