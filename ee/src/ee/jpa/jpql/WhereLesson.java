package ee.jpa.jpql;

import ee.jpa.entities.Book;

import javax.persistence.*;

public class WhereLesson {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bookUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(new Book("title"));
        entityManager.getTransaction().commit();

        TypedQuery<Book> query = entityManager.createQuery("select b.title from Book b where b.id = 1", Book.class);
        Query query1 = entityManager.createQuery("select b.title from Book b where b.id = 1 or b.title = 'MyTitle' And b.id = 2");

        //=, >, >=, <, <=, <>
        Query query2 = entityManager.createQuery("select b.title from Book b where b.id > 1");

        //[NOT] BETWEEN, [NOT] LIKE, [NOT] IN, IS [NOT] NULL, IS [NOT] EMPTY, [NOT] MEMBER [OF]
        Query query3 = entityManager.createQuery("select b.title from Book b where b.id between 1 and 2 and not between 3 and 4");

        Query query4 = entityManager.createQuery("select b.title from Book b where b.id in (1,2)");

        Query query5 = entityManager.createQuery("select b.id from Book b where b.title like '%titl_%'");

        Query query6 = entityManager.createQuery("select b.id from Book b where b.title = (select b.title from Book b where b.title = 'title')");

        Book book = query.getSingleResult();
        System.out.println(book.getId());
        System.out.println(book.getTitle());

        entityManager.close();
        entityManagerFactory.close();
    }
}
