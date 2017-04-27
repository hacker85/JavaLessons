package ee.jpa.ementity;

import javax.persistence.*;

@Entity
public class LiveCycleEntity {
    @Id @GeneratedValue
    int id;
    String name;

    @PrePersist
    void prePersist() {
        System.out.println("prePersist");
    }
    @PostPersist
//    @PostLoad
    void postPersist() {
        System.out.println("postPersist");
    }

    @PostLoad
    void postLoad() {
        System.out.println("postLoad");
    }
    @PreUpdate
    void preUpdate() {
        System.out.println("preUpdate");
    }
    @PostUpdate
    void postUpdate() {
        System.out.println("postUpdate");
    }
    @PreRemove
    void preRemove() {
        System.out.println("preRemove");
    }
    @PostRemove
    void postRemove() {
        System.out.println("postRemove");
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
