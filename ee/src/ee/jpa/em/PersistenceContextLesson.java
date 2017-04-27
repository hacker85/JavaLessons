package ee.jpa.em;

import ee.jpa.entities.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceContextLesson {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bookUnit");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Book book = new Book();
        Book book2 = new Book();
        em.persist(book);
        System.out.println(book.getId());
        em.persist(book);
        System.out.println(book.getId());
        em.persist(book2);
        System.out.println(book2.getId());
        em.getTransaction().commit();

//        EntityManager em2 = emf.createEntityManager();
////        em2.getTransaction().begin();
//        em2.persist(book);
//        System.out.println(book.getId());
////        em2.getTransaction().commit();

//        em2.close();
        em.close();
        emf.close();
    }
}
