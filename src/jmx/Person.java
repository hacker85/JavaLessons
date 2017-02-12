package jmx;

import java.io.Serializable;

/**
 * Created by max on 2/11/17.
 */
public class Person implements Serializable {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
}
