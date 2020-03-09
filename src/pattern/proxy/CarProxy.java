package pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author lwk
 * @date 2019-09-18 16:26
 */
public class CarProxy implements InvocationHandler {
    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before car proxy");
        Object o = method.invoke(car, args);
        System.out.println("after car proxy");
        return o;
    }
}
