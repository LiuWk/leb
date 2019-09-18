package pattern.proxy;

import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

import java.lang.reflect.Method;

/**
 * //代理类
 *
 * @author Administrator
 */
public class VehicleProxy {
    private IVehicle vehicle;

    VehicleProxy(IVehicle vehicle) {
        this.vehicle = vehicle;
    }

    public IVehicle create() {
        final Class<?>[] interfaces = new Class[]{IVehicle.class};
        final VehicleInvocationHandler handler = new VehicleInvocationHandler(vehicle);

        return (IVehicle) Proxy.newProxyInstance(IVehicle.class.getClassLoader(), interfaces, handler);
    }

}

class VehicleInvocationHandler implements InvocationHandler {

    private final IVehicle vehicle;

    VehicleInvocationHandler(IVehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println(method.getName());
        System.out.println("--before running...");
        Object ret = method.invoke(vehicle, args);
        System.out.println("--after running...");

        return ret;
    }

}
