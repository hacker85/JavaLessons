package ee.jpa.entities;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "selectAllBooks", query = "select b from Book b"),
        @NamedQuery(name = "selectFirst", query = "select b from Book b where b.id = 1"),
        @NamedQuery(name = "selectById", query = "select b from Book b where b.id = :id"),
        @NamedQuery(name = NamedBook.FIND_ALL, query = "select b from Book b")
})
@NamedNativeQuery(name = "findAll", query="select * from BOOK", resultClass = Student.class)
@NamedStoredProcedureQuery(name = "updateBooks", procedureName = "updateBookTitle",
        parameters = {
                @StoredProcedureParameter(name = "id", mode = ParameterMode.IN, type = Integer.class),
                @StoredProcedureParameter(name = "newTitle", mode = ParameterMode.IN, type = String.class)
        }
)
public class NamedBook {
    @Id @GeneratedValue
    int id;
    String name;
    public static final String FIND_ALL = "Customer.findAll";

    public NamedBook() {}

    public NamedBook(String name) {
        this.name = name;
    }
}
