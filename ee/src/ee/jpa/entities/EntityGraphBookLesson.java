package ee.jpa.entities;

import javax.persistence.*;

@NamedEntityGraphs({
        @NamedEntityGraph(name = "getOnlyName", attributeNodes = {@NamedAttributeNode("name")})
})
//@NamedEntityGraph
@Entity
public class EntityGraphBookLesson {
    @Id
    @GeneratedValue
    int id;
    @Basic(fetch = FetchType.EAGER)
    String title;
    String author;
    String name;
    String content;
}
