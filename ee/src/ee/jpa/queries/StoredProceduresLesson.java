package ee.jpa.queries;

import ee.jpa.entities.Book;

import javax.persistence.*;

public class StoredProceduresLesson {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bookUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(new Book("title"));
        entityManager.getTransaction().commit();

        StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery("updateBooks");
        query.setParameter("bookId", 1);
        query.setParameter("newTitle", "Book new title");
        query.execute();

        StoredProcedureQuery updateBookTitle = entityManager.createStoredProcedureQuery("updateBook");
        updateBookTitle.registerStoredProcedureParameter("bookId", Integer.class, ParameterMode.IN);
        updateBookTitle.registerStoredProcedureParameter("newTitle", String.class, ParameterMode.IN);
        updateBookTitle.setParameter("bookId", 1);
        updateBookTitle.setParameter("newTitle", "Book new title");
        updateBookTitle.execute();

        entityManager.close();
        entityManagerFactory.close();
    }
}
