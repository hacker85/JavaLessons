package ee.jpa.jpql;

import ee.jpa.entities.Book;

import javax.persistence.*;

public class ParametersLesson {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bookUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(new Book("title"));
        entityManager.getTransaction().commit();

        TypedQuery<Book> query = entityManager.createQuery("select b from Book b where b.title = ?1 and b.title <> ?2", Book.class);
        Query query1 = entityManager.createQuery("select b from Book b where b.title = :title and b.title <> :wrongTitle");

        query.setParameter(1, "title");
        query.setParameter(2, "1");
        Book book = query.getSingleResult();
        System.out.println(book.getId());
        System.out.println(book.getTitle());

        entityManager.close();
        entityManagerFactory.close();
    }
}
