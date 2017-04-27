package ee.jpa.advanced;

import ee.jpa.ementity.VersionBook;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class VersioningLesson {
    public static void main(String[] args) throws InterruptedException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bookUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityManager entityManager2 = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        VersionBook book = new VersionBook("title");
        VersionBook book2 = new VersionBook("title");
        System.out.println(book.getVersion());
        entityManager.persist(book);
        System.out.println(book.getVersion());
        book.setTitle("new");
        entityManager.merge(book);
        entityManager.persist(book2);
        entityManager.getTransaction().commit();
        System.out.println(book.getVersion());
        System.out.println(book2.getVersion());

        entityManager.getTransaction().begin();
        book.setTitle("new one");
        entityManager.merge(book);
        entityManager.getTransaction().commit();
        System.out.println(book.getVersion());

        entityManager.close();
        entityManager2.close();
        entityManagerFactory.close();
    }
}
