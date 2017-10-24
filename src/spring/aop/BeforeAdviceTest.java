package spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
//@Aspect
public class BeforeAdviceTest {
	@Before("execution(* spring.aop.entity.*.*(..))")
	public void toDo(){
		System.out.println("before advice to do.");
	}
}