package spring.aop.entity;

import org.springframework.stereotype.Component;

@Component
public interface Human  {
	void sleep();
	void bleath();
	String sayHello(String name); 
	void eat(String food); 
}
