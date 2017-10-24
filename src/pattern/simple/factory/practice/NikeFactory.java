package pattern.simple.factory.practice;

public class NikeFactory implements Factory {

	@Override
	public FootBall factoryMethod() {
		return new Nike();
	}

}
