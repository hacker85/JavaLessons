package ee.cdi;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/elb")
public class ELBeans extends HttpServlet {
    @Inject
    ELBean elBean;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/ELBean.jsp");
        requestDispatcher.forward(req, resp);
    }
}
@ApplicationScoped
@Named("elbean")
class ELBean {
    private String s = "hello";

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }
}