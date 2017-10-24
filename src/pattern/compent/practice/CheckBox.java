package pattern.compent.practice;

public class CheckBox extends GUI {
	private String checkBoxName;

	@Override
	public void add(GUI g) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(GUI g) {
		// TODO Auto-generated method stub

	}

	/**
	 * @param checkBoxName
	 */
	public CheckBox(String checkBoxName) {
		super();
		this.checkBoxName = checkBoxName;
		System.out.println("创建单选框：" + checkBoxName);
	}

}
