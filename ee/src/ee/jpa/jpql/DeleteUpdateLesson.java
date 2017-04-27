package ee.jpa.jpql;

import ee.jpa.entities.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DeleteUpdateLesson {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bookUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(new Book("title"));
        entityManager.getTransaction().commit();

        Query query = entityManager.createQuery("delete from Book b where b.id = 1");
        Query query2 = entityManager.createQuery("update Book b set b.title = 'new title' where b.id = 1");
        query.executeUpdate();


        entityManager.close();
        entityManagerFactory.close();
    }
}
