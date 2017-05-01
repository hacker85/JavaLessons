package ee.ejb;

import ee.ejb.beans.SessionContextDIBean;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/sessionContextLesson")
public class SessionContextDILesson extends HttpServlet {
    @EJB
    SessionContextDIBean sessionContextDIBean;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        sessionContextDIBean.doJob();
    }
}
