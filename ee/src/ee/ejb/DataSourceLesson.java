package ee.ejb;

import ee.ejb.beans.DataSourceBean;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/dataSourceLesson")
public class DataSourceLesson extends HttpServlet {
    @EJB
    DataSourceBean bean;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        bean.saveBook();
    }
}
