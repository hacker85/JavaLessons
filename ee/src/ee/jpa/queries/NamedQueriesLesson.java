package ee.jpa.queries;

import ee.jpa.entities.NamedBook;

import javax.persistence.*;
import java.util.List;

public class NamedQueriesLesson {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bookUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(new NamedBook("title"));
        entityManager.getTransaction().commit();

        Query query = entityManager.createNamedQuery("selectAllBooks");
        List<NamedBook> books = query.getResultList();

        TypedQuery<NamedBook> query2 = entityManager.createNamedQuery("selectAllBooks", NamedBook.class);
        List<NamedBook> books2 = query.getResultList();

        Query query3 = entityManager.createNamedQuery("selectById");
        query3.setParameter("id", 1);
        List<NamedBook> books3 = query.getResultList();

        Query query4 = entityManager.createNamedQuery("selectById").setParameter("id", 1).setMaxResults(1);
        List<NamedBook> books4 = query.getResultList();

        Query query5 = entityManager.createNamedQuery(NamedBook.FIND_ALL);
        List<NamedBook> books5 = query.getResultList();

        entityManager.close();
        entityManagerFactory.close();
    }
}
