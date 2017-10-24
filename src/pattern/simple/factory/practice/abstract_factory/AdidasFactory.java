package pattern.simple.factory.practice.abstract_factory;

public class AdidasFactory implements ProductFactory {

	@Override
	public Sneakers createSneakers() {
		System.out.println("create a pair of adidas sneakers.");
		return new AdidasSneakers();
	}

	@Override
	public Socks createSocks() {
		System.out.println("create a pair of adidas socks.");
		return new AdidasSocks();
	}
 

}
