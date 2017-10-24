package pattern.template;


//：活期账户类，充当具体子类。
public class CurrentAccount extends Account {

	//覆盖父类的抽象基本方法
	@Override
	void calculateInterest() {
		System.out.println("按照活期计算利率！");
	}

}
