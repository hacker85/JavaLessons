package ee.jpa.jpql;

import ee.jpa.entities.Book;

import javax.persistence.*;

public class SelectLesson {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bookUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(new Book("title"));
        entityManager.getTransaction().commit();

//    SELECT <select clause>
//    FROM <from clause>
//    [WHERE <where clause>]
//    [ORDER BY <order by clause>]
//    [GROUP BY <group by clause>]
//    [HAVING <having clause>]

//    SELECT [DISTINCT] <expression> [[AS] <identification variable>]
//    expression ::= { NEW | TREAT | AVG | MAX | MIN | SUM | COUNT }

        TypedQuery<Book> query = entityManager.createQuery("select b from Book b", Book.class);
        Query query1 = entityManager.createQuery("select b from Book b where b.title = 'title'");

        Query query2 = entityManager.createQuery("select b.title, b.id from Book b");
        Query query3 = entityManager.createQuery("select case b.id when 1 then 'one'  else 'two' end from Book b");

        Query query4 = entityManager.createQuery("select c.address.title from Customer c");

        Query query5 = entityManager.createQuery("select new Book(b.title) from Book b");

        Query query6 = entityManager.createQuery("select distinct b.title from Book b");

        //avg, count, max, min, sum
        Query query7 = entityManager.createQuery("select count(b) from Book b");

        //ABS, SQRT, MOD, SIZE, INDEX
        //CONCAT, SUBSTRING, TRIM, LOWER, UPPER, LENGTH, LOCATE
        //CURRENT_DATE, CURRENT_TIME, CURRENT_TIMESTAMP
        Query query8 = entityManager.createQuery("select UPPER(b.title) from Book b");

        Book book = query.getSingleResult();
        System.out.println(book.getId());
        System.out.println(book.getTitle());

        entityManager.close();
        entityManagerFactory.close();
    }
}
