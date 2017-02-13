package internationalization;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by max on 2/13/17.
 */
public class CollatorLesson {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(3);
        list.add("Bi");
        list.add("cc");
        list.add("бб");
        list.add("ÅÅ");
        list.add("AA");
        list.add("aa");

        Collator collator = Collator.getInstance();
        collator.setStrength(Collator.PRIMARY);//A=Å A=a
        //collator.setStrength(Collator.SECONDARY);//A!=Å A=a
        //collator.setStrength(Collator.TERTIARY);//A!=Å A!=a
        Collections.sort(list, collator);
        for(String s : list) {
            System.out.println(s);
        }
    }
}
