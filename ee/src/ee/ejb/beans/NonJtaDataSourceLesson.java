package ee.ejb.beans;

import ee.jpa.entities.Book;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.*;
import java.io.IOException;

@WebServlet("/nonJtaDSLesson")
public class NonJtaDataSourceLesson extends HttpServlet {
    @PersistenceContext
    EntityManager entityManager;
    @Resource
    UserTransaction userTransaction;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            userTransaction.begin();
            entityManager.persist(new Book("nonTitle"));
            userTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
