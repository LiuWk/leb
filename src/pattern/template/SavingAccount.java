package pattern.template;

//定期账户类，充当具体子类。
public class SavingAccount extends Account {
	@Override
	void calculateInterest() {
		System.out.println("按照定期计算利率！");
	}

}
