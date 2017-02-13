package internationalization;

import java.text.MessageFormat;
import java.util.GregorianCalendar;

/**
 * Created by max on 2/13/17.
 */
public class MessageFormatLesson {
    public static void main(String[] args) {
        System.out.println(MessageFormat.format("On {2}, a {0} destroyed {1} houses and caused {3} of damage.",
                "hurricane", 99, new GregorianCalendar(1999, 0, 1).getTime(), 10.0E8));

        System.out.println(MessageFormat.format("On {2,date,long}, a {0} destroyed {1,choice,0#no houses|1#one house|2#{1} houses} and caused {3,number,currency} of damage.",
                "hurricane", 99, new GregorianCalendar(1999, 0, 1).getTime(), 10.0E8));

        //number        integer,currency,percent
        //time, date    short,medium,long,full
        //choice
    }
}
