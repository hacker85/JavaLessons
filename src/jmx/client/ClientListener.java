package jmx.client;

import javax.management.AttributeChangeNotification;
import javax.management.Notification;
import javax.management.NotificationListener;

public class ClientListener implements NotificationListener {

    public void handleNotification(Notification notification,
                                   Object handback) {
        System.out.println("Received notification:");
        System.out.println("ClassName: " + notification.getClass().getName());
        System.out.println("Source: " + notification.getSource());
        System.out.println("Type: " + notification.getType());
        System.out.println("Message: " + notification.getMessage());
        if (notification instanceof AttributeChangeNotification) {
            AttributeChangeNotification acn =
                    (AttributeChangeNotification) notification;
            System.out.println("AttributeName: " + acn.getAttributeName());
            System.out.println("AttributeType: " + acn.getAttributeType());
            System.out.println("NewValue: " + acn.getNewValue());
            System.out.println("OldValue: " + acn.getOldValue());
        }
    }
}