package pattern.simple.factory.practice.abstract_factory;

public class Client {
	public static void main(String[] args) {
		ProductFactory f = new AdidasFactory();//可配置替换为其他工厂
		f.createSneakers();
		f.createSocks();
	}
}
