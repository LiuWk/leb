package pattern.proxy;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

//代理类
public class VehicalProxy {
	private IVehical vehical;

	public VehicalProxy(IVehical vehical) {
		this.vehical = vehical;
	}

	public IVehical create() {
		final Class<?>[] interfaces = new Class[] { IVehical.class };
		final VehicalInvacationHandler handler = new VehicalInvacationHandler(vehical);

		return (IVehical) Proxy.newProxyInstance(IVehical.class.getClassLoader(), interfaces, handler);
	}

}

class VehicalInvacationHandler implements InvocationHandler {

	private final IVehical vehical;

	public VehicalInvacationHandler(IVehical vehical) {
		this.vehical = vehical;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		System.out.println(method.getName());
		System.out.println("--before running...");
		Object ret = method.invoke(vehical, args);
		System.out.println("--after running...");

		return ret;
	}

}
