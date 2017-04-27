package ee.jpa.em;

import ee.jpa.entities.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ContainsClearDetachLesson {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bookUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Book book = new Book("title");
        entityManager.persist(book);
        entityManager.getTransaction().commit();
        System.out.println(entityManager.contains(book));

        entityManager.getTransaction().begin();
        entityManager.remove(book);
        entityManager.getTransaction().commit();
        System.out.println(entityManager.contains(book));

        entityManager.getTransaction().begin();
        entityManager.detach(book);
//        entityManager.clear();
        entityManager.getTransaction().commit();
        System.out.println(entityManager.contains(book));

        entityManager.close();
        entityManagerFactory.close();
    }
}
