package servlets;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/readContext")
public class ContextReadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        ServletContext servletContext1 = servletContext.getContext("/readContext");
        Enumeration<String> attributeNames = servletContext1.getAttributeNames();
        while(attributeNames.hasMoreElements()) {
            String s = attributeNames.nextElement();
            System.out.println(s + " = " + servletContext1.getAttribute(s));
        }
//        System.out.println(servletContext1.getAttribute("qwe"));
//        System.out.println(req.getServletContext().getAttribute("qwe"));
    }
}
