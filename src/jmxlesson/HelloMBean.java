package jmxlesson;

/**
 * Created by max on 2/12/17.
 */
public interface HelloMBean {
    void sayHello();
    int addIntegers(int a, int b);

    Person returnPerson();

    String getName();
    void setName(String name);
}
