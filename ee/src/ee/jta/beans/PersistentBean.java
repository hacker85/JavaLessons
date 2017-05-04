package ee.jta.beans;

import ee.jpa.entities.Book;

import javax.ejb.Singleton;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
//@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class PersistentBean {
    @PersistenceContext
    EntityManager entityManager;
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void saveBook() {
        entityManager.persist(new Book("jta book"));
    }
}
