//package spring.aop;
//
//import java.lang.reflect.InvocationHandler;
//import java.lang.reflect.Method;
//
//public class SleepHelper implements InvocationHandler {
//	public Human human;
//	@Override
//	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//		System.out.println("takeoff cloth.");
//		Object reult = method.invoke(human, args);
//		return null;
//	}
//
//}
