package swing;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by husiv on 9/16/16.
 */
public class TimeZoneFix {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();//newReleaseMessage.getMessageHeader().getMessageCreatedDateTime();
        calendar.setTimeZone(TimeZone.getTimeZone("Europe/London"));
        Date messageCreatedDateTime = calendar.getTime();
    }
}
