package pattern.proxy;

import org.checkerframework.checker.units.qual.C;
import org.joda.time.DateTime;

import java.lang.reflect.Proxy;
import java.util.Date;

public class Client {
    static int a=10;
    static {a+=5;}


    public static void main(String[] args) {
        System.out.println(a);
        IVehicle car = new Car();
//        VehicleProxy proxy = new VehicleProxy(car);
//
//        IVehicle proxyObj = proxy.create();
//        proxyObj.run();

        CarProxy cp = new CarProxy();
        cp.setCar(new Car());
        IVehicle carP = (IVehicle) Proxy.newProxyInstance(Client.class.getClassLoader(), new Class[]{IVehicle.class}, cp);
        carP.run();

        Date endTime = new DateTime().withTimeAtStartOfDay().toDate();
        //昨日凌晨
        Date startTime = new DateTime().plusDays(-1).withTimeAtStartOfDay().toDate();
        System.out.println(endTime);
        System.out.println(startTime);
        A ab = new B();
         ab = new B();
    }

    static {a/=3;}

}

class A{
    static {
        System.out.print("1");
    }
    public A(){
        System.out.print("2");
    }
}

class B extends A{
    static {
        System.out.print("a");
    }
    public B(){
        System.out.print("b");
    }
}