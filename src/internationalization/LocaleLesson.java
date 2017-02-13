package internationalization;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by max on 2/12/17.
 */
public class LocaleLesson {
    public static void main(String[] args) {
        Locale locale = new Locale("en", "US");
        Locale locale2 = Locale.ENGLISH;
        Locale locale3 = Locale.getDefault();
        //Locale.setDefault(Locale.ENGLISH);
        System.out.println(Locale.getDefault());

        Locale[] supportedLocales = DateFormat.getAvailableLocales();
        for (Locale locale1 : supportedLocales) {
            //System.out.println(locale1.getDisplayName());
        }

        double amt = 123456.78;
        System.out.println(NumberFormat.getCurrencyInstance(locale).format(amt));
        System.out.println(NumberFormat.getCurrencyInstance(locale3).format(amt));
        System.out.println(NumberFormat.getCurrencyInstance(new Locale("de", "DE")).format(amt));

        System.out.println(DateFormat.getDateInstance(DateFormat.FULL, locale).format(new Date()));
        System.out.println(DateFormat.getDateInstance(DateFormat.FULL, Locale.GERMAN).format(new Date()));
        System.out.println(DateFormat.getDateInstance(DateFormat.FULL, locale3).format(new Date()));
    }
}
