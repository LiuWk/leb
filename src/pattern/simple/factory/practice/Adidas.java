package pattern.simple.factory.practice;

public class Adidas implements FootBall{

	@Override
	public void display() {
		System.out.println("阿迪达斯足球！");
	}

	/**
	 * 
	 */
	public Adidas() {
		super();
		System.out.println("阿迪达斯足球初始化！");
	}
	
}
