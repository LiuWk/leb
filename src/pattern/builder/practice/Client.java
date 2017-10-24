package pattern.builder.practice;

public class Client {
	public static void main(String[] args) {
//		Builder b = new SpainBuilder();//可配置
		Builder b = new ItalyBuilder();//可配置
		Director d = new Director(b);
		Equipment eq = d.construct();
		System.out.println("get a equiment "+
						"color="+eq.getColor()+",size="+eq.getSize());
	}
}
