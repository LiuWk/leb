package pattern.observer;

import java.util.ArrayList;

//战队控制中心类：目标类
public abstract class AllyControlCenter {
	protected String allyName; // 战队名称
	protected ArrayList<Observer> players = new ArrayList<Observer>(); // 定义一

	public void setAllyName(String allyName) {
		this.allyName = allyName;
	}

	public String getAllyName() {
		return this.allyName;
	}

	// 注册方法
	public void join(Observer obs) {
		System.out.println(obs.getName() + "加入" + this.allyName + "战队！");
		players.add(obs);
	}

	// 注销方法
	public void quit(Observer obs) {
		System.out.println(obs.getName() + "退出" + this.allyName + "战队！");
		players.remove(obs);
	}

	// 声明抽象通知方法
	public abstract void notifyObserver(String name);
}

// 具体战队控制中心类：具体目标类
class ConcreteAllyControlCenter extends AllyControlCenter {
	public ConcreteAllyControlCenter(String allyName) {
		System.out.println(allyName + "战队组建成功！");
		System.out.println("----------------------------");
		this.allyName = allyName;
	}

	// 实现通知方法
	@Override
    public void notifyObserver(String name) {
		System.out.println(this.allyName + "战队紧急通知，盟友" + name + "遭受敌人攻击");
		// 遍历观察者集合，调用每一个盟友（自己除外）的支援方法
		for (Object obs : players) {
			if (!((Observer) obs).getName().equalsIgnoreCase(name)) {
				((Observer) obs).help();
			}
		}
	}
}