package ee.ejb.beans;

import ee.jpa.entities.Book;

import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
@Startup
@DataSourceDefinition(
        className = "com.mysql.jdbc.Driver",
        name = "java:global/ee/DataSourceBean",
        user = "root",
        password = "1",
        portNumber = 3306,
        initialPoolSize = 5,
        url = "jdbc:mysql://localhost:3306/Lessons"
)
public class DataSourceBean {
    @PersistenceContext
    EntityManager entityManager;
    public void saveBook() {
        entityManager.persist(new Book("savedBook"));
    }
}
