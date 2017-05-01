package ee.ejb;

import ee.ejb.beans.LiveCycleBean;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/liveCycleLesson")
public class LiveCycleServletLesson extends HttpServlet {
    @EJB
    LiveCycleBean liveCycleBean;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write(liveCycleBean.getName());
    }
}
