package ee.ejb;

import ee.ejb.beans.DependsOnAndStartupBean1;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/dependsExample")
public class DependsOnAndStartupServletLesson extends HttpServlet {
    @EJB
    DependsOnAndStartupBean1 dependsOnAndStartupBean1;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        dependsOnAndStartupBean1.print();
    }
}
