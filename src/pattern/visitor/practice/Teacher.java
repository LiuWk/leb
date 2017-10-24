package pattern.visitor.practice;

public class Teacher implements Person {
	private String name;

	/**
	 * @param name
	 * @param papersNum
	 * @param feedbackPoints
	 */
	public Teacher(String name, int papersNum, int feedbackPoints) {
		super();
		this.name = name;
		this.papersNum = papersNum;
		this.feedbackPoints = feedbackPoints;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private int papersNum;
	private int feedbackPoints;

	public int getPapersNum() {
		return papersNum;
	}

	public void setPapersNum(int papersNum) {
		this.papersNum = papersNum;
	}

	public int getFeedbackPoints() {
		return feedbackPoints;
	}

	public void setFeedbackPoints(int feedbackPoints) {
		this.feedbackPoints = feedbackPoints;
	}

	@Override
	public void accept(AwardVisitor award) {
		award.visit(this);
	}

}
