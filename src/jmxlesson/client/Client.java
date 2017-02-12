package jmxlesson.client;

import jmxlesson.HelloMBean;

import javax.management.*;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.io.IOException;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by max on 2/12/17.
 */
public class Client {
    public static void main(String[] args) throws IOException, MalformedObjectNameException, InstanceNotFoundException, InterruptedException {
        JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://:9999/jmxrmi");
        JMXConnector jmxc = JMXConnectorFactory.connect(url, null);
        MBeanServerConnection mbsc = jmxc.getMBeanServerConnection();

        ObjectName mbeanName = new ObjectName("jmxlesson:type=Hello");
        HelloMBean mbeanProxy = JMX.newMBeanProxy(mbsc, mbeanName, HelloMBean.class, true);

        mbsc.addNotificationListener(mbeanName, new ClientListener(), null, null);

        mbeanProxy.sayHello();
        Thread.sleep(1000);
        System.out.println(mbeanProxy.addIntegers(1,2));
        mbeanProxy.setName("hello");
        System.out.println(mbeanProxy.getName());
        System.out.println(mbeanProxy.returnPerson().getName());

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

        jmxc.close();
    }
}
