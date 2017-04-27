package ee.jpa.entities;

import javax.persistence.*;

@Entity
//@DiscriminatorValue("SubClassExample")
@AttributeOverrides({@AttributeOverride(name = "age", column = @Column(name = "PersonAge"))})
public class InheritanceStrategiesLesson extends ParentClass {
//    @Id @GeneratedValue
//    int subId;
    String name = "Max";
}
@Entity
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@Inheritance(strategy = InheritanceType.JOINED)
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "className", discriminatorType = DiscriminatorType.STRING)
//@DiscriminatorValue("ParentClass")
//abstract
class ParentClass extends CommonParrent {
    int age = 22;
}
@MappedSuperclass
//@Inheritance(strategy = InheritanceType.JOINED)
class CommonParrent {
    @Id @GeneratedValue
    int id;
    @Column(name = "title")
    String title;
}