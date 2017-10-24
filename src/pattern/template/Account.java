package pattern.template;

public abstract class Account {
	boolean validate(String account, String password) {
		System.out.println("账号：" + account);
		System.out.println("密码：" + password);
		// 模拟登录
		if (account.equals("张无忌") && password.equals("123456")) {
			return true;
		} else {
			return false;
		}
	}

	// 基本方法——抽象方法
	abstract void calculateInterest();

	// 基本方法——具体方法
	void display() {
		System.out.println("显示利息！");
	}

	// 模板方法
	void handle(String account, String password) {
		if (!validate(account, password)) {
			System.out.println("账户或密码错误！");
			return;
		}
		calculateInterest();
		display();
	}
}
