import entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConfigHiberLesson {
    public static void main(String[] args) {
        Configuration cfg = new Configuration()
                .setProperty("hibernate.dialect", "org.hibernate.dialect.MariaDBDialect")
                .setProperty("hibernate.connection.username", "root")
                .setProperty("hibernate.connection.password", "1")
                .setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/Lessons")
                .configure();
        try(SessionFactory sessionFactory = cfg.buildSessionFactory();
            Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(new Student("Max"));
            session.getTransaction().commit();
        }
    }
}
