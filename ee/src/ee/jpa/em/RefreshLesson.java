package ee.jpa.em;

import ee.jpa.entities.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RefreshLesson {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bookUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Book book = new Book("title");
        entityManager.persist(book);
        entityManager.getTransaction().commit();
        book.setTitle("new Title");
        entityManager.refresh(book);
        System.out.println(book.getTitle());

        entityManager.close();
        entityManagerFactory.close();
    }
}
