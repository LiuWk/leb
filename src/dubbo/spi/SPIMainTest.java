package dubbo.spi;

import java.util.ServiceLoader;

/**
 * SPI 全称为 Service Provider Interface，是一种服务发现机制。
 * SPI 的本质是将接口实现类的全限定名配置在文件中，并由服务加载器读取配置文件，
 * 加载实现类。这样可以在运行时，动态为接口替换实现类。正因此特性，
 * 我们可以很容易的通过 SPI 机制为我们的程序提供拓展功能。SPI 机制在第三方框架中也有所应用，
 * 比如 Dubbo 就是通过 SPI 机制加载所有的组件。不过，Dubbo 并未使用 Java 原生的 SPI 机制，
 * 而是对其进行了增强，使其能够更好的满足需求。在 Dubbo 中，SPI 是一个非常重要的模块。
 * 基于 SPI，我们可以很容易的对 Dubbo 进行拓展。如果大家想要学习 Dubbo 的源码，SPI 机制务必弄懂。
 * 接下来，我们先来了解一下 Java SPI 与 Dubbo SPI 的用法，然后再来分析 Dubbo SPI 的源码。
 */
public class SPIMainTest {
    public static void main(String[] args) {
        ServiceLoader<Robot> loader = ServiceLoader.load(Robot.class);
        System.out.println("java spi.");
        loader.forEach(Robot::sayHello);
    }
}

