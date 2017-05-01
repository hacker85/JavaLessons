package ee.ejb;

import ee.ejb.beans.XmlBean;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/xmlServlet")
public class XmlServletLesson extends HttpServlet {
    @EJB
    XmlBean xmlBean;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write(xmlBean.sayHello());
    }
}
