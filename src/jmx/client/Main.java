package jmx.client;

import jmx.HelloMBean;
import jmx.Person;

import javax.management.JMX;
import javax.management.MBeanServerConnection;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by max on 2/11/17.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://:9999/jmxrmi");
        JMXConnector jmxc = JMXConnectorFactory.connect(url, null);
        MBeanServerConnection mbsc = jmxc.getMBeanServerConnection();

        System.out.println("Domains:");
        String domains[] = mbsc.getDomains();
        Arrays.sort(domains);
        for (String domain : domains) {
            System.out.println("Domain = " + domain);
        }


        System.out.println("MBeanServer default domain = " + mbsc.getDefaultDomain());

        System.out.println("MBean count = " +  mbsc.getMBeanCount());
        System.out.println("Query MBeanServer MBeans:");
        Set<ObjectName> names =
                new TreeSet<ObjectName>(mbsc.queryNames(null, null));
        for (ObjectName name : names) {
            System.out.println("ObjectName = " + name);
        }


        ClientListener listener = new ClientListener();



        ObjectName mbeanName = new ObjectName("jmx:type=Hello");
        HelloMBean mbeanProxy = JMX.newMBeanProxy(mbsc, mbeanName, HelloMBean.class, true);

        System.out.println("Add notification listener...");
        mbsc.addNotificationListener(mbeanName, listener, null, null);

        System.out.println("CacheSize = " + mbeanProxy.getCacheSize());

        mbeanProxy.setCacheSize(150);

        System.out.println("Waiting for notification...");
        Thread.sleep(1000);
        System.out.println("CacheSize = " + mbeanProxy.getCacheSize());
        System.out.println("Invoke sayHello() in Hello MBean...");
        mbeanProxy.sayHello();

        System.out.println("Invoke add(2, 3) in Hello MBean...");
        System.out.println("add(2, 3) = " + mbeanProxy.add(2, 3));

        Person person = mbeanProxy.returnPerson();
        System.out.println("Name: " + mbeanProxy.getName());

        System.out.println("Press <Enter> to continue...");
        System.in.read();

        jmxc.close();
    }
}
