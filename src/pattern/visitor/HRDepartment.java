package pattern.visitor;

//人力资源部类：具体访问者类
public class HRDepartment extends Department {

	@Override
	public void visit(FulltimeEmployee employee) {
		int workTime = employee.getWorkTime();
		System.out.println("正式员工" + employee.getName() + "实际工作时间为：" + workTime);
		if (workTime > 40) {
			System.out.println("正式员工" + employee.getName() + "加班时间为：" + "");
		} else if (workTime < 40) {
			System.out.println("正式员工" + employee.getName() + "请假时间为：" + "");
		}
	}

	@Override
	public void visit(ParttimeEmployee employee) {
		int workTime = employee.getWorkTime();
		System.out.println("临时工" + employee.getName() + "实际工作时间" + workTime);
	}

}
