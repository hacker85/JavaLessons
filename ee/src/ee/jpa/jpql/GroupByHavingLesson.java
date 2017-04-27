package ee.jpa.jpql;

import ee.jpa.entities.Book;

import javax.persistence.*;
import java.util.List;

public class GroupByHavingLesson {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bookUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(new Book("title"));
        entityManager.persist(new Book("title"));
        entityManager.persist(new Book("title2"));
        entityManager.persist(new Book("title2"));
        entityManager.getTransaction().commit();

        Query query = entityManager.createQuery("select count(b) from Book b where b.id <> 1 group by b.title having count(b) > 1");
//        Query query1 = entityManager.createQuery("select count(b) from Book b group by b.title");
//        Query query2 = entityManager.createQuery("select b.title count(b) from Book b group by b.title having b.title <> 'title'");
//        Query query3 = entityManager.createQuery("select b.title count(b) from Book b where b.title <> 'title' group by b.title");

        List<Long> books = query.getResultList();
        for(Long book1: books) {
            System.out.println(book1);
//            System.out.println(book1.getId());
//            System.out.println(book1.getTitle());
        }

        entityManager.close();
        entityManagerFactory.close();
    }
}
