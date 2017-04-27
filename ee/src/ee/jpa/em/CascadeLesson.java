package ee.jpa.em;

import ee.jpa.ementity.Customer;
import ee.jpa.ementity.CustomerAddress;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CascadeLesson {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bookUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        CustomerAddress customerAddress = new CustomerAddress("customberStreet", "customberCity");
        Customer customer = new Customer("Max" ,customerAddress);
        entityManager.persist(customer);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
