package ee.cdi;


import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/dia")
public class DIAlternative extends HttpServlet {
    @Inject
    ParentA parentA;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write(parentA.doJob());
    }
}

interface ParentA {
    String doJob();
}
@Alternative
class ChildOneA implements ParentA {
    @Override
    public String doJob() {
        return "one";
    }
}
class ChildTwoA implements ParentA {
    @Override
    public String doJob() {
        return "two";
    }
}