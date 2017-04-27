package ee.jpa;

import ee.jpa.entities.Book;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/jpaExample")
public class ServletExample extends HttpServlet {
    @EJB
    JpaBean jpaBean;
//@Resource
//UserTransaction utx;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = new Book("servlet");
        jpaBean.saveBook(book);
        resp.getWriter().write(book.getId() + "");
    }
}