package pattern.template;

public class Client {
	public static void main(String[] args) {
		Account acc = (Account) XMLUtil.getBean(0);
		acc.handle("张无忌", "123456");
		System.out.println("");
		Account acc1 = (Account) XMLUtil.getBean(1);
		acc1.handle("张无忌", "1234561");
		
	}
}
