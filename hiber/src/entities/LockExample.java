package entities;

import entities.hierarchies.Car;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class LockExample {
    public static void main(String[] args) throws InterruptedException {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        try(SessionFactory sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
            Session session = sessionFactory.openSession();
            Session session2 = sessionFactory.openSession()) {

            session.beginTransaction();
            Car car = new Car("123");
            session.persist(car);
            session.getTransaction().commit();

            final int carId = car.getId();

            new Thread() {
                @Override
                public void run() {
                    session.beginTransaction();
                    Car car = session.load(Car.class, carId, LockMode.PESSIMISTIC_WRITE);
                    car.setNumber(car.getNumber() + "4");
                    try {Thread.sleep(400);} catch (InterruptedException e) {}
                    session.getTransaction().commit();
                }
            }.start();

            new Thread() {
                @Override
                public void run() {
                    session2.beginTransaction();
                    Car car = session2.load(Car.class, carId, LockMode.PESSIMISTIC_WRITE);
                    car.setNumber(car.getNumber() + "5");
                    session2.getTransaction().commit();
                }
            }.start();
            Thread.sleep(600);
        }
    }
}
