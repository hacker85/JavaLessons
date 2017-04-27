package ee.jpa.queries;

import ee.jpa.entities.Book;

import javax.persistence.*;
import java.util.List;

public class DinamicQueriesLesson {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bookUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(new Book("title"));
        entityManager.getTransaction().commit();

        Query query = entityManager.createQuery("select b from Book b");
        List<Book> books = query.getResultList();

        TypedQuery<Book> query2 = entityManager.createQuery("select b from Book b", Book.class);
        List<Book> books2 = query.getResultList();

        TypedQuery<Book> single = entityManager.createQuery("select b from Book b", Book.class);
        Book book2 = single.getSingleResult();

        int id = 1;
        String queryString = "select b from Book b where b.id = " + id;
        Query query3 = entityManager.createQuery(queryString);
        List<Book> books3 = query.getResultList();

        Query query4 = entityManager.createQuery("select b from Book b where b.id = ?1");
        query4.setParameter(1, id);
        List<Book> books4 = query.getResultList();

        Query query5 = entityManager.createQuery("select b from Book b where b.id = :id");
        query5.setParameter("id", id);
        List<Book> books5 = query.getResultList();

        Query query6 = entityManager.createQuery("select b from Book b");
        query6.setMaxResults(5);
        List<Book> books6 = query.getResultList();

        entityManager.close();
        entityManagerFactory.close();
    }
}
