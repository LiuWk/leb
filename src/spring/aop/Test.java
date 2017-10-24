package spring.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.aop.entity.Human;

public class Test {

	public static void main(String[] args) {
//		// 创建 Spring 容器
		@SuppressWarnings("resource")
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application-bean.xml");
		Human p = ctx.getBean("chinese", Human.class);
		System.out.println(p.sayHello("张三"));
		p.eat("西瓜");
		System.out.println(p.getClass()); 
		
	}

}
