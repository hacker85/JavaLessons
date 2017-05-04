package ee.jta.beans;

import ee.jpa.entities.Student;

import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.*;

@Singleton
@TransactionManagement(TransactionManagementType.BEAN)
public class ManagedTransactionBean {
    @PersistenceContext
    EntityManager entityManager;
    @Resource
    UserTransaction userTransaction;
    public void saveStudent() {
        try {
            userTransaction.begin();
            entityManager.persist(new Student("Max"));
            userTransaction.commit();
        } catch (NotSupportedException e) {
            e.printStackTrace();
        } catch (SystemException e) {
            e.printStackTrace();
        } catch (HeuristicMixedException e) {
            e.printStackTrace();
        } catch (HeuristicRollbackException e) {
            e.printStackTrace();
        } catch (RollbackException e) {
            e.printStackTrace();
        }
    }
}
