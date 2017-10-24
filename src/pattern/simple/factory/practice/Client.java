package pattern.simple.factory.practice;

public class Client {

	public static void main(String[] args) {
		Factory f = new AdidasFactory();
		FootBall ball = f.factoryMethod();
		ball.display();
		
	}

}
