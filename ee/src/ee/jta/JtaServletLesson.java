package ee.jta;

import ee.jta.beans.JtaBean;
import ee.jta.beans.PersistentBean;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/jtaServlet")
public class JtaServletLesson extends HttpServlet {
    @EJB
    JtaBean jtaBean;
    @EJB
    PersistentBean persistentBean;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        jtaBean.saveBook();
        persistentBean.saveBook();
    }
}
