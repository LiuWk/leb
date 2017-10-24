package pattern.compent.practice;

public class Button extends GUI {
	private String buttonName;

	/**
	 * @param buttonName
	 */
	public Button(String buttonName) {
		super();
		this.buttonName = buttonName;
		System.out.println("创建按钮：" + buttonName);
	}

	@Override
	public void add(GUI g) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(GUI g) {
		// TODO Auto-generated method stub

	}

}
