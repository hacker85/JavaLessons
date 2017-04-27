package ee.jpa.advanced;

import ee.jpa.ementity.ListenerEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PrePersist;

public class ListenersLesson {
    @PrePersist
    void prePersist(ListenerEntity listenerEntity) {
        System.out.println("prePersist " + listenerEntity.getId());
    }
    public static void main(String[] args) throws InterruptedException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bookUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(new ListenerEntity());
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
