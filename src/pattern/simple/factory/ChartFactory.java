package pattern.simple.factory;

public class ChartFactory {
	// ¾²Ì¬¹¤³§·½·¨
	public static Chart getChart(String type) {
		Chart chart = null;
		if (type.equalsIgnoreCase("histogram")) {
			chart = new HistogramChart();
			System.out.println("初始化设置柱状图！");
		} else if (type.equalsIgnoreCase("pie")) {
			chart = new PieChart();
			System.out.println("初始化设置饼状图！");
		} else {
			System.out.println("ERROR");
		}
		return chart;
	}
}
