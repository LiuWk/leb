package pattern.simple.factory;
//饼状图类：具体产品类
public class PieChart implements Chart {

	public PieChart() {
		super();
		System.out.println("饼状图创建");
	}

	@Override
	public void display() {
		System.out.println("饼状图展示");
	}

}
