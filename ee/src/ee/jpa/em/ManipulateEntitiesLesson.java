package ee.jpa.em;

import ee.jpa.entities.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ManipulateEntitiesLesson {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bookUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(new Book("title"));
        entityManager.getTransaction().commit();
//        entityManager.getTransaction().rollback();

        Book book = entityManager.find(Book.class, 1);
        System.out.println(book.getId());
        System.out.println(book.getTitle());

        //fetch data lazy
        Book reference = entityManager.getReference(Book.class, 1);
        System.out.println(reference.getId());
        System.out.println(reference.getTitle());

        entityManager.getTransaction().begin();
        entityManager.remove(book);
        entityManager.getTransaction().commit();

        System.out.println("------------");

        System.out.println(book.getId());
        System.out.println(book.getTitle());

        entityManager.close();
        entityManagerFactory.close();
    }
}
