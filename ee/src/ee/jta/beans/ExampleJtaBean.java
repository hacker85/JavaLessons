package ee.jta.beans;

import ee.jpa.entities.Student;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
public class ExampleJtaBean {
    @PersistenceContext
    EntityManager entityManager;
    public void saveStudent() {
        entityManager.persist(new Student("Max"));
    }
}