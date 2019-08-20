package jmx;

import javax.management.*;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXServiceURL;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

/**
 * @author lwk
 * @date 2019-08-20 14:54
 */
public class TestJmx {
    private static final String JMX = "service:jmx:rmi:///jndi/rmi://%s/jmxrmi";
    private static final String URI = "10.240.169.114:9393";

    public static void main(String[] args) {
        JMXServiceURL jmxSeriverUrl = null;
        try {
            jmxSeriverUrl = new JMXServiceURL(String.format(JMX, URI));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        JMXConnector connector = null;
        try {
//            String objName = "kafka.controller:type=KafkaController,name=OfflinePartitionsCount";
//            String objName = "kafka.network:type=SocketServer,name=NetworkProcessorAvgIdlePercent";
            String objName = "kafka.controller:type=KafkaController,name=ActiveControllerCount";
            String attribute = "Value";
            connector = JMXFactoryUtils.connectWithTimeout(jmxSeriverUrl, 30, TimeUnit.SECONDS);
            MBeanServerConnection mbeanConnection = connector.getMBeanServerConnection();
            System.out.println(mbeanConnection.isRegistered(new ObjectName(objName)));
            String value = mbeanConnection.getAttribute(new ObjectName(objName), attribute).toString();
            System.out.println(value);
        } catch (IOException | MalformedObjectNameException | MBeanException | AttributeNotFoundException
                | InstanceNotFoundException | ReflectionException e) {
            e.printStackTrace();
        }
    }
}
