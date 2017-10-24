package pattern.visitor;

//兼职员工类：具体元素类
public class ParttimeEmployee implements Employee {
	private String name;
	private double hourWage;
	private int workTime;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param name
	 * @param hourWage
	 * @param workTime
	 */
	public ParttimeEmployee(String name, double hourWage, int workTime) {
		super();
		this.name = name;
		this.hourWage = hourWage;
		this.workTime = workTime;
	}

	public double getHourWage() {
		return hourWage;
	}

	public void setHourWage(double hourWage) {
		this.hourWage = hourWage;
	}

	public int getWorkTime() {
		return workTime;
	}

	public void setWorkTime(int workTime) {
		this.workTime = workTime;
	}

	@Override
	public void accept(Department handler) {
		handler.visit(this); //调用访问者的访问方法
	}

}
