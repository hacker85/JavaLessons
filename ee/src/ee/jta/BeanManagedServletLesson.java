package ee.jta;

import ee.jta.beans.ManagedTransactionBean;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/beanManagedServlet")
public class BeanManagedServletLesson extends HttpServlet {
    @EJB
    ManagedTransactionBean managedTransactionBean;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        managedTransactionBean.saveStudent();
    }
}
