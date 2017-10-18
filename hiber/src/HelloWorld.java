import entities.HomeAddress;
import entities.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HelloWorld {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        try(SessionFactory sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
            Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            HomeAddress homeAddress = new HomeAddress("Lenina");
            List<HomeAddress> list = new ArrayList<>();
            list.add(homeAddress);
            list.add(new HomeAddress("Gukova"));

            List<Integer> marks = new ArrayList<>();
            marks.add(1);
            marks.add(3);
            marks.add(2);

//            Map<String, String> map = new HashMap<>();
//            map.put("one", "1");
//            map.put("two", "2");

            Person person = new Person("Max", list, marks, "123");
//            session.persist(homeAddress);
            session.persist(person);

            Map<String, String> book = new HashMap<>();
            book.put( "isbn", "978-9730228236" );
            book.put( "title", "High-Performance Java Persistence" );
            book.put( "author", "Vlad Mihalcea" );

            session.save( "Book", book );

            Person iCode = session.byNaturalId(Person.class).using("iCode", "123").getReference();
            System.out.println(iCode);

            Person load = session.load(Person.class, 85);
//            System.out.println(load.getMarks());
//            List<HomeAddress> homeAddress = load.getHomeAddress();
            session.getTransaction().commit();
        }
    }
}
