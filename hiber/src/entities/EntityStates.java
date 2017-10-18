package entities;

import entities.hierarchies.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class EntityStates {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        try(SessionFactory sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
            Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            session.getTransaction().commit();
            Car car = new Car("123");
            System.out.println(car.getId());
            session.persist(car);
            session.flush();
            System.out.println(car.getId());
//            car.setNumber("321");
//            session.detach(car);
//            car.setNumber("456");
////            session.merge(car);
//            session.update(car);
//            session.remove(car);
//            System.out.println(car.getId());
//            System.out.println(car.getNumber());
            car.setNumber("789");
            session.refresh(car);
            System.out.println(car.getNumber());

            session.getTransaction().commit();
        }
    }
}
