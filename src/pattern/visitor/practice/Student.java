package pattern.visitor.practice;

public class Student implements Person {
	private String name;

	/**
	 * @param name
	 * @param papersNum
	 * @param averageScore
	 */
	public Student(String name, int papersNum, int averageScore) {
		super();
		this.name = name;
		this.papersNum = papersNum;
		this.averageScore = averageScore;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private int papersNum;
	private int averageScore;

	public int getPapersNum() {
		return papersNum;
	}

	public void setPapersNum(int papersNum) {
		this.papersNum = papersNum;
	}

	public int getAverageScore() {
		return averageScore;
	}

	public void setAverageScore(int averageScore) {
		this.averageScore = averageScore;
	}

	@Override
	public void accept(AwardVisitor award) {
		award.visit(this);
	}

}
