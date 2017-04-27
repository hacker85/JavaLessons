package ee.jpa.queries;

import ee.jpa.entities.Book;
import ee.jpa.entities.Book_;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class CriteriaApiLesson {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bookUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(new Book("title"));
        entityManager.getTransaction().commit();

        //select b from Book b where b.title = 'title'

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Book> criteriaQuery = criteriaBuilder.createQuery(Book.class);
        Root<Book> b = criteriaQuery.from(Book.class);
//        criteriaQuery.select(b).where(criteriaBuilder.equal(b.get("title"),"title"));
        criteriaQuery.select(b).where(criteriaBuilder.equal(b.get(Book_.title),"title"));
        Query query = entityManager.createQuery(criteriaQuery);
        List<Book> books = query.getResultList();

        entityManager.close();
        entityManagerFactory.close();
    }
}
