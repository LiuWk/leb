package dubbo.spi;

import org.apache.dubbo.common.extension.ExtensionLoader;

public class DubboSPITest {
    public static void main(String[] args) {
        ExtensionLoader<Robot> load = ExtensionLoader.getExtensionLoader(Robot.class);
        Robot optimusPrime = load.getExtension("optimusPrime");
        optimusPrime.sayHello();
        Robot bumblebee = load.getExtension("bumblebee");
        bumblebee.sayHello();
    }
}
