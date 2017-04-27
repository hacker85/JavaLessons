package ee.jpa.advanced;

import ee.jpa.ementity.LiveCycleEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CallbacksLesson {
    public static void main(String[] args) throws InterruptedException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bookUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        LiveCycleEntity liveCycleEntity = new LiveCycleEntity();
        System.out.println("persist");
        entityManager.persist(liveCycleEntity);
        entityManager.getTransaction().commit();
        System.out.println("-------------");

        entityManager.getTransaction().begin();
        System.out.println("clear");
        entityManager.clear();
        System.out.println("merge");
        entityManager.merge(liveCycleEntity);
        liveCycleEntity.setName("qwe");
        entityManager.merge(liveCycleEntity);
        entityManager.getTransaction().commit();
        System.out.println("-------------");

        entityManager.getTransaction().begin();
        System.out.println("find");
        LiveCycleEntity liveCycleEntity1 = entityManager.find(LiveCycleEntity.class, 1);
        entityManager.getTransaction().commit();
        System.out.println("-------------");

        entityManager.getTransaction().begin();
        System.out.println("refresh");
        entityManager.refresh(liveCycleEntity1);
        liveCycleEntity1.setName("asd");
        entityManager.getTransaction().commit();
        System.out.println("-------------");

        entityManager.getTransaction().begin();
        System.out.println("remove");
        entityManager.remove(liveCycleEntity1);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
