package ee.jpa.entities;

import javax.persistence.*;

@Entity
//@TableGenerator(name="tab", initialValue=0, allocationSize=3)
//@SequenceGenerator(name="seq", initialValue=1, allocationSize=100)
public class GenValuePerson {
//    @TableGenerator(name="Emp_Gen",
//            table="ID_GEN",
//            pkColumnName="GEN_NAME",
//            valueColumnName="GEN_VAL",
//            initialValue=10000,
//            allocationSize=100)
//@SequenceGenerator(name="Emp_Gen", sequenceName="Emp_Seq")
    @Id @GeneratedValue//(strategy = GenerationType.SEQUENCE, generator="Emp_Gen")//(strategy = GenerationType.SEQUENCE, generator = "seq")
    int id;
    String name;

    public GenValuePerson() {
    }

    public GenValuePerson(String name) {
        this.name = name;
    }
}
