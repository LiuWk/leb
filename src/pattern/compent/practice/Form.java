package pattern.compent.practice;

import java.util.ArrayList;
import java.util.List;

//窗体类
public class Form extends GUI {
	private List<GUI> list = new ArrayList<>();
	private String formName;

	@Override
	public void add(GUI g) {
		list.add(g);
	}

	@Override
	public void remove(GUI g) {
		list.remove(g);
	}

	/**
	 * @param formName
	 */
	public Form(String formName) {
		super();
		this.formName = formName;
		System.out.println("创建窗体：" + formName);
	}

}
