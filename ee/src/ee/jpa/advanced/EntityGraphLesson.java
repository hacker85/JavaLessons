package ee.jpa.advanced;

import ee.jpa.entities.EntityGraphBookLesson;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EntityGraphLesson {
    public static void main(String[] args) throws InterruptedException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bookUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        EntityGraphBookLesson entityGraphBookLesson = new EntityGraphBookLesson();
        entityManager.persist(entityGraphBookLesson);
        entityManager.getTransaction().commit();

        EntityGraph<EntityGraphBookLesson> entityGraph = entityManager.createEntityGraph(EntityGraphBookLesson.class);
        entityGraph.addAttributeNodes("author");
        Map hints = new HashMap();
        hints.put("javax.persistence.fetchgraph", entityGraph);
        EntityGraphBookLesson book = entityManager.find(EntityGraphBookLesson.class, 1, hints);

        Map hints2 = new HashMap();
        hints2.put("javax.persistence.loadgraph", entityGraph);
        EntityGraphBookLesson book2 = entityManager.find(EntityGraphBookLesson.class, 1, hints2);

        EntityGraph eg = entityManager.createEntityGraph("getOnlyName");
        List<EntityGraphBookLesson> messages = entityManager.createQuery("select e from EntityGraphBookLesson e")
                .setHint("javax.persistence.loadgraph", eg)
                .getResultList();

        entityManager.close();
        entityManagerFactory.close();
    }
}
