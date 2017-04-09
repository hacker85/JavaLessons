package ee.cdi;

import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/scope")
public class Scope extends HttpServlet {
    @Inject
    ScopeBean scopeBean;
    @Inject
    Wrapper wrapper;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        scopeBean.i = 1;
        wrapper.changeI();
        resp.getWriter().write("i = " + scopeBean.i);
    }
}
//@ApplicationScoped
//@SessionScoped
//@RequestScoped
//@ConversationScoped
@Dependent //default
class ScopeBean {
    int i;
}

@RequestScoped
class Wrapper {
    @Inject
    ScopeBean bean;
    void changeI() {
        bean.i = 2;
    }
}
