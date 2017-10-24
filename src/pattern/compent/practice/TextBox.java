package pattern.compent.practice;

public class TextBox extends GUI {
	private String textBoxName;

	@Override
	public void add(GUI g) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(GUI g) {
		// TODO Auto-generated method stub

	}

	/**
	 * @param textBoxName
	 */
	public TextBox(String textBoxName) {
		super();
		this.textBoxName = textBoxName;
		System.out.println("创建文本框：" + textBoxName);
	}

}
