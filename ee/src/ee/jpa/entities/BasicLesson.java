package ee.jpa.entities;

import javax.persistence.*;

@Entity
public class BasicLesson {
    @Id @GeneratedValue
    int id;
    @Basic(fetch = FetchType.LAZY, optional = false)
    @Lob
    byte[] img;
}
