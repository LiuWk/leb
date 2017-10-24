package spring.aop;

import spring.aop.cglib.ChineseProxyFactory;
import spring.aop.entity.Chinese;

public class Test2 {

	public static void main(String[] args) {
		Chinese cn = ChineseProxyFactory.getAuthInstance();
		System.out.println(cn.sayHello("孙悟空"));
		cn.eat("西瓜");
		cn.sleep();
		System.out.println(cn.getClass());
	}

}
