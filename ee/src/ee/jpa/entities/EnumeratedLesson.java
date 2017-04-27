package ee.jpa.entities;

import javax.persistence.*;

@Entity
public class EnumeratedLesson {
    @Id @GeneratedValue
    int id;
    @Enumerated(EnumType.STRING)
    Gender gender;

    public EnumeratedLesson() {
        gender = Gender.MALE;
    }
}
enum Gender {MALE, ALIEN, FIMALE}