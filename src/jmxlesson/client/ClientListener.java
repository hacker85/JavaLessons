package jmxlesson.client;

import javax.management.AttributeChangeNotification;
import javax.management.Notification;
import javax.management.NotificationListener;
import java.util.Date;

/**
 * Created by max on 2/12/17.
 */
public class ClientListener implements NotificationListener {
    @Override
    public void handleNotification(Notification notification, Object handback) {
        System.out.println(notification.getMessage());
        System.out.println(notification.getType());
        System.out.println(new Date(notification.getTimeStamp()));
        if(notification instanceof AttributeChangeNotification) {
            AttributeChangeNotification attributeChangeNotification = (AttributeChangeNotification) notification;
            System.out.println(attributeChangeNotification.getAttributeName());
            System.out.println(attributeChangeNotification.getAttributeType());
            System.out.println(attributeChangeNotification.getNewValue());
        }
    }
}
