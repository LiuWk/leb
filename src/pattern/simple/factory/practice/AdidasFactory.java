package pattern.simple.factory.practice;

public class AdidasFactory implements Factory{

	@Override
	public FootBall factoryMethod() {
		return new Adidas();
	}
	 
}
