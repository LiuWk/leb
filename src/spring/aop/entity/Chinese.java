package spring.aop.entity;

import org.springframework.stereotype.Component;

@Component
public class Chinese implements Human{
	// 实现 Person 接口的 sayHello() 方法
	@Override
    public String sayHello(String name) {
		System.out.println("-- 正在执行 sayHello 方法 --");
		// 返回简单的字符串
		return name + " Hello , Spring AOP";
	}
	// 定义一个 eat() 方法
	@Override
    public void eat(String food) {
		System.out.println("我正在吃 :" + food);
	}
	
	@Override
	public void sleep() {
		// TODO Auto-generated method stub
		System.out.println("I am sleeping");
	}
	@Override
	public void bleath() {
		// TODO Auto-generated method stub
		
	}
}
