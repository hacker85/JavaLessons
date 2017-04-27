package ee.jpa.entities;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
public class TemproralLesson {
    @Id @GeneratedValue
    int id;
    @Temporal(TemporalType.TIME)
    Calendar date;

    public TemproralLesson() {
        date = Calendar.getInstance();//new Date();
        date.setTime(new Date());
    }
}
