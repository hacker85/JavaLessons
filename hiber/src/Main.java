import entities.hierarchies.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.NativeQuery;

import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        try(SessionFactory sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
            Session session = sessionFactory.openSession()) {

            session.beginTransaction();
            NativeQuery nativeQuery = session.createNativeQuery("select * from Car", Car.class);
            List<Car> resultList = nativeQuery.getResultList();
            for (Car car : resultList) {
                System.out.println("id " + car.getId() + " number " + car.getNumber());
            }
            session.getTransaction().commit();

//            session.beginTransaction();
//            Query query = session.createNamedQuery("getCarByNumber");
//            query.setParameter("number", "123");
//            Car car = (Car) query.uniqueResult();
//            System.out.println(car.getId());
//            session.getTransaction().commit();

//            session.beginTransaction();
//            session.createQuery("update Car c set c.number = '234' where c.id = 247").executeUpdate();
//            session.createQuery("insert into Car (id,number) select c.id + 4, concat(c.number, '1') from Car c where c.id = 247").executeUpdate();
//            session.createQuery("delete Car c where c.id = 251").executeUpdate();
//            session.getTransaction().commit();

//            session.beginTransaction();
//            Query query = session.createQuery("from Car c where c.number != '123'");
//            =, >, >=, <, <=, <>, !=
//            Query query = session.createQuery("from Car c where c.number is not null");
//            Query query = session.createQuery("from Car c where c.number like '%123%'");
//            Query query = session.createQuery("from Car c where number BETWEEN 1 and 1000");
//            Query query = session.createQuery("from Car c where number in (123,1234)");
//            Query query = session.createQuery("from Car c where c.number is empty");
//            Query query = session.createQuery("from Car c where c.number = '123' or c.number = '2' and c.number = '3'");
//            Query query = session.createQuery("from Car c where number = 123L");
//            Query query = session.createQuery("from Car c where number = 123.0");
//            Query query = session.createQuery("from Car c where number = 123.0F");
//            Query query = session.createQuery("from Car c where number = 120 + 3");
//            Query query = session.createQuery("from Car c where number = 12 || 3");
//            List<Car> list = query.list();
//            for (Car car : list) {
//                System.out.println(car.getNumber());
//            }
//            session.getTransaction().commit();

//            session.beginTransaction();
//            User user = new User("Max");
//            Role admin = new Role("admin");
//            Role moderator = new Role("moderator");
//            List<Role> roles = new ArrayList<>();
//            roles.add(admin);
//            roles.add(moderator);
//            user.setRoleList(roles);
//            session.persist(user);
//            session.getTransaction().commit();

//            session.beginTransaction();
////            Query query = session.createQuery("from User");
//            Query query = session.createQuery("select distinct u from User u join fetch u.roleList");
//            List<User> list = query.list();
//            session.getTransaction().commit();
//
//            for (User user : list) {
//                System.out.println(user.getName());
//                System.out.println(user.getRoleList().size());
//            }

//            session.beginTransaction();
//            Query query = session.createQuery("select max(id) from Car c");
//            Query query = session.createQuery("select min(id) from Car c");
//            Query query = session.createQuery("select count(id) from Car c");
//            Query query = session.createQuery("select sum(id) from Car c");
//            Query query = session.createQuery("select avg(id) from Car c");
//            jpql
//            Query query = session.createQuery("select concat(id, ' id') from Car c");
//            Query query = session.createQuery("select substring(c.number, 0,1) from Car c");
//            Query query = session.createQuery("select upper(c.number) from Car c");
//            Query query = session.createQuery("select lower(c.number) from Car c");
//            Query query = session.createQuery("select trim(c.number) from Car c");
//            Query query = session.createQuery("select length(c.number) from Car c");
//            Query query = session.createQuery("select locate('1', c.number) from Car c");
//            Query query = session.createQuery("select abs(number) from Car c");
//            Query query = session.createQuery("select mod(number, 10) from Car c");
//            Query query = session.createQuery("select sqrt(number) from Car c");
//            Query query = session.createQuery("select current_date from Car c");
//            Query query = session.createQuery("select current_time from Car c");
//            Query query = session.createQuery("select current_timestamp from Car c");
//            hql
//            Query query = session.createQuery("select bit_length(c.number) from Car c");
//            Query query = session.createQuery("select cast(c.number as string) from Car c");
//            Query query = session.createQuery("select extract(YEAR from current_timestamp) from Car c");
//            Query query = session.createQuery("select year(current_timestamp) from Car c");
//            Query query = session.createQuery("select DAY(current_timestamp) from Car c");
//            Query query = session.createQuery("select MONTH(current_timestamp) from Car c");
//            Query query = session.createQuery("select HOUR(current_timestamp) from Car c");
//            Query query = session.createQuery("select MINUTE(current_timestamp) from Car c");
//            Query query = session.createQuery("select SECOND(current_timestamp) from Car c");
//            Query query = session.createQuery("select STR(current_timestamp) from Car c");
//            List<String> list = query.list();
//            for (String str : list) {
//                System.out.println(str);
//            }
//            session.getTransaction().commit();
        }
    }
}
