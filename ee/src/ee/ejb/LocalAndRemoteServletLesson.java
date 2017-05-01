package ee.ejb;

import ee.ejb.beans.LocalAndRemoteBean;
import ee.ejb.beans.interfaces.LocalBeanInteface;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/localRemote")
public class LocalAndRemoteServletLesson extends HttpServlet {
    @EJB
    LocalBeanInteface localBeanInteface;
    @EJB
    LocalAndRemoteBean localAndRemoteBean;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write(localBeanInteface.sayHello() + ": ");
        resp.getWriter().write(localAndRemoteBean.sayHello() + " ");
        resp.getWriter().write(localAndRemoteBean.sayLocalHello());
    }
}
