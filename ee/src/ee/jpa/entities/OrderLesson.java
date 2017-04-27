package ee.jpa.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class OrderLesson {
    @Id @GeneratedValue
    int id;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @OrderBy("i DESC")
    @OrderColumn(name = "orderColumn")
    List<OrderName> orderNames;

    public OrderLesson() {
        orderNames = new ArrayList<>();
        orderNames.add(new OrderName(1));
        orderNames.add(new OrderName(3));
        orderNames.add(new OrderName(2));
    }
    public void print() {
        for(OrderName orderName : orderNames) {
            System.out.println(orderName.i);
        }
    }

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bookUnit");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        OrderLesson orderLesson = em.find(OrderLesson.class, 1);
        orderLesson.print();
        tx.commit();

        em.close();
        emf.close();
    }
}

@Entity
class OrderName {
//    @Id @GeneratedValue
//    int id;
    @Id
    int i;

    public OrderName() {
    }

    public OrderName(int i) {
        this.i = i;
    }
}
