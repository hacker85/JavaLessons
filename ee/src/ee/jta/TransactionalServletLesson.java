package ee.jta;

import ee.jpa.entities.Book;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.IOException;

@WebServlet("/transactionalServlet")
public class TransactionalServletLesson extends HttpServlet {
    @Inject
    TestTransaction testTransaction;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        testTransaction.saveBook();
    }
}
@RequestScoped
@Transactional
//@Transactional(rollbackOn={Exception.class}, dontRollbackOn={IllegalStateException.class})
class TestTransaction {
    @PersistenceContext
    EntityManager entityManager;
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void saveBook() {
        entityManager.persist(new Book("title"));
    }
}