package ee.jta;

import ee.jpa.entities.Book;

import javax.annotation.Resource;
import javax.ejb.ApplicationException;
import javax.ejb.SessionContext;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
public class RolbackExceptionBean {
    @PersistenceContext
    EntityManager entityManager;
    @Resource
    SessionContext sessionContext;
    public void saveBook() throws Exception {
        entityManager.persist(new Book("new Name"));
//        sessionContext.setRollbackOnly();
//        throw new RuntimeException();
//        throw new InventoryLevelTooLowException();
        throw new Exception();
    }
}
@ApplicationException(rollback = true)
class InventoryLevelTooLowException extends Exception {

    public InventoryLevelTooLowException() { }

    public InventoryLevelTooLowException(String message) {
        super(message);
    }
}
