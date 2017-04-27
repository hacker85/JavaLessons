package ee.jpa.em;

import ee.jpa.ementity.Customer;
import ee.jpa.ementity.CustomerAddress;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FlushLesson {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bookUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        CustomerAddress customerAddress = new CustomerAddress("customberStreet", "customberCity");
        Customer customer = new Customer("Max" ,customerAddress);
        entityManager.persist(customer);
        entityManager.flush();
//        entityManager.persist(customerAddress);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
