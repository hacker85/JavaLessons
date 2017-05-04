package ee.jta;

import ee.jta.beans.ExampleJtaBean;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/exampleJtaServlet")
public class ExampleServlet extends HttpServlet {
    @EJB
    ExampleJtaBean exampleJtaBean;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        exampleJtaBean.saveStudent();
    }
}