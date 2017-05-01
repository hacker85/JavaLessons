package ee.ejb;

import ee.ejb.beans.TimeServiceBean;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/timeServiceLesson")
public class TimeServiceServletLesson extends HttpServlet {
    @EJB
    TimeServiceBean timeServiceBean;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        timeServiceBean.setTimer();
    }
}
