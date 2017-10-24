package spring.aop.cglib;

import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

import spring.aop.entity.Chinese;
import spring.aop.entity.Human;

public class Client {

	public static void main(String[] args) {
	    Chinese c = ChineseProxyFactory.getAuthInstance();
	    c.sayHello("aaa");
	    
	    Human h = ChineseProxyFactory.getHumanAuthInstance();
	    h.sayHello("bbb");
	}
	 
}
