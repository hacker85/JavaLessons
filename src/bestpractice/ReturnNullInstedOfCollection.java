package bestpractice;

import java.util.ArrayList;
import java.util.Collection;

//never return null from method that return collection or array, better return empty array
//don't make user of you api to do your job
//programmer can forget //it can shot in a years
public class ReturnNullInstedOfCollection {
    public static void main(String[] args) {
        Collection<String> collection = getCollection();
        if(collection != null) {
            //some code
        }
    }
    static Collection<String> getCollection() {
        Collection<String> collection = new ArrayList<>();
        //some code
        return collection;
    }
}
