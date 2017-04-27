package ee.jpa.queries;

import ee.jpa.entities.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class NativeQueriesLesson {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bookUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(new Book("title"));
        entityManager.getTransaction().commit();

        Query query = entityManager.createNativeQuery("SELECT * FROM BOOK", Book.class);
        List<Book> books = query.getResultList();

        //Named Query
//        @NamedNativeQuery(name = "findAll", query="select * from BOOK")

        entityManager.close();
        entityManagerFactory.close();
    }
}
