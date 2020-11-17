package pattern.proxy;

import org.joda.time.DateTime;

import java.lang.reflect.Proxy;
import java.util.Date;

/**
 * 为何jdk动态代理必须有接口，不支持仅实现类的代理
 * 查看jdk的动态代理源码发现：
 * <p>
 *     动态代理实际上是程序在运行中，根据被代理的接口来动态生成代理类的class文件，并加载class文件运行的过程，
 * 通过反编译被生成的$Proxy0.class文件发现：
 * <p>
 *     class类定义为：
 * <p>
 *     public final class $Proxy0 extends Proxy implements Interface {
 *         public $Proxy0(InvocationHandler paramInvocationHandler) {  
 *             super(paramInvocationHandler);  
 *           } 
 * <p>
 *         ...
 * <p>
 *         ...
 *         // 该方法为被代理接口的业务方法，代理类都会自动生成相应的方法，里面去执行invocationHandler 的invoke方法。
 * <p>
 *         public final void sayHello(String paramString) {  
 *             try {  
 *                 this.h.invoke(this, m3, new Object[] { paramString });  
 *                 return;  
 *             }  
 *             catch (Error|RuntimeException localError) {  
 *                 throw localError;  
 *             }  
 *             catch (Throwable localThrowable) {  
 *                 throw new UndeclaredThrowableException(localThrowable);  
 *             }  
 *       } 
 *     }
 * <p>
 *     由于java的单继承，动态生成的代理类已经继承了Proxy类的，就不能再继承其他的类，所以只能靠实现被代理类的接口的形式，
 * 故JDK的动态代理必须有接口。
 * 另外，为何调用代理类的方法就会自动进入InvocationHandler 的 invoke（）方法呢？
 * 其实是因为在动态代理类的定义中，构造函数是含参的构造，参数就是我们invocationHandler 实例，
 * 而每一个被代理接口的方法都会在代理类中生成一个对应的实现方法，并在实现方法中最终调用invocationHandler 的invoke方法，
 * 这就解释了为何执行代理类的方法会自动进入到我们自定义的invocationHandler的invoke方法中，
 * 然后在我们的invoke方法中再利用jdk反射的方式去调用真正的被代理类的业务方法，而且还可以在方法的前后去加一些我们自定义的逻辑。
 * 比如切面编程AOP等。
 */
public class Client {
    static int a = 10;

    static {
        a += 5;
    }


    public static void main(String[] args) {
//        System.out.println(a);
//        IVehicle car = new Car();
//        VehicleProxy proxy = new VehicleProxy(car);
//
//        IVehicle proxyObj = proxy.create();
//        proxyObj.run();
        // 代理对象的 class 文件写入到磁盘中
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        CarProxy cp = new CarProxy();
        cp.setCar(new Car());
        IVehicle carP = (IVehicle) Proxy.newProxyInstance(Client.class.getClassLoader(), new Class[]{IVehicle.class}, cp);
        carP.run();


        /*A ab = new B();
        ab = new B();*/
    }

    static {
        a /= 3;
    }

}

class A {
    static {
        System.out.print("1");
    }

    public A() {
        System.out.print("2");
    }
}

class B extends A {
    static {
        System.out.print("a");
    }

    public B() {
        System.out.print("b");
    }
}