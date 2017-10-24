package pattern.visitor.practice;

public class ConcreteVisitor extends AwardVisitor {

	@Override
	public void visit(Student s) {
		String name = s.getName();
		if (s.getPapersNum() > 2) {
			System.out.println("学生姓名：" + name + " 获得评选科研奖资格！");
		}
		if (s.getAverageScore() >= 90) {
			System.out.println("学生姓名：" + name + " 获得评选成绩优秀奖资格！");
		}
	}

	@Override
	public void visit(Teacher t) {
		String name = t.getName();
		int papersNum = t.getPapersNum();
		if (papersNum  > 10) {
			System.out.println("教师姓名：" + name + " 获得评选科研奖资格！");
		}
		int feedbackPoints = t.getFeedbackPoints();
		if(feedbackPoints  >= 90){
			System.out.println("教师姓名：" + name + " 获得评选成绩优秀奖资格！");
		}
	}

}
