package pattern.simple.factory.practice;

public class Nike implements FootBall{

	@Override
	public void display() {
		System.out.println("耐克足球！");
	}

	/**
	 * 
	 */
	public Nike() {
		super();
		System.out.println("耐克足球初始化！");
	}
	
}
