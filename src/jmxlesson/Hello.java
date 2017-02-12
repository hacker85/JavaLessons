package jmxlesson;

import javax.management.AttributeChangeNotification;
import javax.management.MBeanNotificationInfo;
import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;

/**
 * Created by max on 2/12/17.
 */
public class Hello extends NotificationBroadcasterSupport implements HelloMBean {
    private String name;
    static int sequenceNumber = 0;

    @Override
    public void sayHello() {
        System.out.println("hello from jmx");

        Notification notification = new AttributeChangeNotification(this, sequenceNumber++, System.currentTimeMillis(),
                "I sad hello", "sequenceNumber", "int", sequenceNumber - 1, sequenceNumber);

        sendNotification(notification);
    }

    @Override
    public int addIntegers(int a, int b) {
        return a + b;
    }

    @Override
    public Person returnPerson() {
        return new Person();
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public MBeanNotificationInfo[] getNotificationInfo() {
        String[] types = new String[]{
                AttributeChangeNotification.ATTRIBUTE_CHANGE
        };

        String name = AttributeChangeNotification.class.getName();
        String description = "An attribute of this MBean has changed";
        MBeanNotificationInfo info = new MBeanNotificationInfo(types, name, description);
        return new MBeanNotificationInfo[]{info};
    }
}
