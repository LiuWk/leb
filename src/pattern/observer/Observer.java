package pattern.observer;

import java.util.Observable;

//抽象观察类
public interface Observer {
	public String getName();

	public void setName(String name);

	public void help(); // 声明支援盟友方法

	public void beAttacked(AllyControlCenter acc); // 声明遭受攻击方法
}

// 战队成员类：具体观察者类
class Player implements Observer {
	private String name;

	public Player(String name) {
		this.name = name;
	}

	@Override
    public void setName(String name) {
		this.name = name;
	}

	@Override
    public String getName() {
		return this.name;
	}

	// 支援盟友方法的实现
	@Override
    public void help() {
		System.out.println("坚持住，" + this.name + "来救你！");
	}

	// 遭受攻击方法的实现，当遭受攻击时将调用战队控制中心类的通知方法notifyObserver()来通知
	@Override
    public void beAttacked(AllyControlCenter acc) {
		System.out.println(this.name + "被攻击！");
		acc.notifyObserver(name);
	}
}

class Singger extends Observable{
	private String name = "";
	 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		setChanged();//标记此 Observable对象为已改变的对象
		notifyObservers();//通知所有观察者
	}
	
}

class SinggerObserver implements java.util.Observer{

	@Override
	public void update(Observable o, Object obj) {
		Singger s = (Singger) o;
		
		System.out.println("change song " + s.getName());
	}
	
}