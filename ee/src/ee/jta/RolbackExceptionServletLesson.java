package ee.jta;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/rolbackExceptionServlet")
public class RolbackExceptionServletLesson extends HttpServlet {
    @EJB
    RolbackExceptionBean rolbackExceptionBean;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            rolbackExceptionBean.saveBook();
        } catch (InventoryLevelTooLowException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
