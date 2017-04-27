package ee.jpa.em;

import ee.jpa.entities.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MerginLesson {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bookUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Book book = new Book("title");
        entityManager.persist(book);
        book.setTitle("middle title");
        entityManager.getTransaction().commit();
        System.out.println(entityManager.contains(book));

        entityManager.clear();
        System.out.println(entityManager.contains(book));
        book.setTitle("new Title");

        entityManager.getTransaction().begin();
//        entityManager.persist(book);
        entityManager.merge(book);
        entityManager.getTransaction().commit();
        System.out.println(entityManager.contains(book));

        entityManager.close();
        entityManagerFactory.close();
    }
}
