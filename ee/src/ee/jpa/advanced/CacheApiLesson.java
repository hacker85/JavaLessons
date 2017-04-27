package ee.jpa.advanced;

import ee.jpa.entities.Book;

import javax.persistence.*;

public class CacheApiLesson {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bookUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Book book = new Book("title");
        entityManager.persist(book);
        entityManager.getTransaction().commit();

        Cache cache = entityManagerFactory.getCache();
        System.out.println(cache.contains(Book.class, book.getId()));
        cache.evict(Book.class, book);
        cache.evictAll();
        System.out.println(cache.contains(Book.class, book.getId()));

        entityManager.close();
        entityManagerFactory.close();
    }
}
@Entity
@Cacheable(true)
class CachedEntiti {}