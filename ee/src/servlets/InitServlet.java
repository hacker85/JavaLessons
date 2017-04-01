package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class InitServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("init method");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("init servlet");
        Enumeration<String> initParameterNames = getServletConfig().getInitParameterNames();
        while(initParameterNames.hasMoreElements()) {
            String s = initParameterNames.nextElement();
            System.out.println(s + " = " + getServletConfig().getInitParameter(s));
        }
        System.out.println(getServletContext().getInitParameter("email"));
    }
}
