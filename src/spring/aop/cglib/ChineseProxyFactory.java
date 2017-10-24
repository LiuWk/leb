package spring.aop.cglib;

import org.springframework.cglib.proxy.Enhancer;

import spring.aop.entity.Chinese;
import spring.aop.entity.Human;

public class ChineseProxyFactory {
	public static Chinese getAuthInstance() {
		Enhancer en = new Enhancer();
		// 设置要代理的目标类
		en.setSuperclass(Chinese.class);
		// 设置要代理的拦截器
		en.setCallback(new AroundAdvice());
		// 生成代理类的实例
		return (Chinese) en.create();
	}
	public static Human getHumanAuthInstance() {
	    Enhancer en = new Enhancer();
	    // 设置要代理的目标类
	    en.setSuperclass(Human.class);
	    // 设置要代理的拦截器
	    en.setCallback(new AroundAdvice());
	    // 生成代理类的实例
	    return (Human) en.create();
	}
}