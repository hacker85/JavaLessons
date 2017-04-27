package ee.jpa.advanced;

import ee.jpa.ementity.VersionBook;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;

public class ConcurencyAndLockingLesson {
    public static void main(String[] args) throws InterruptedException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bookUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityManager entityManager2 = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        VersionBook book = new VersionBook("title");
        entityManager.persist(book);
        entityManager.getTransaction().commit();

        new Thread() {
            @Override
            public void run() {
                entityManager.getTransaction().begin();
                VersionBook book1 = entityManager.find(VersionBook.class, 1, LockModeType.OPTIMISTIC);
//                entityManager.lock(book1, LockModeType.PESSIMISTIC_WRITE);
                book1.setTitle(book1.getTitle() + "1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {}
                entityManager.getTransaction().commit();
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                entityManager2.getTransaction().begin();
                VersionBook book2 = entityManager2.find(VersionBook.class, 1, LockModeType.OPTIMISTIC);
                book2.setTitle(book2.getTitle() + "2");
                entityManager2.getTransaction().commit();
            }
        }.start();

        Thread.sleep(2000);
        entityManager.close();
        entityManager2.close();
        entityManagerFactory.close();
    }
}