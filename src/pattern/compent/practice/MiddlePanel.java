package pattern.compent.practice;

import java.util.ArrayList;
import java.util.List;

public class MiddlePanel extends GUI {
	private List<GUI> list = new ArrayList<>();
	private String panelName;
	@Override
	public void add(GUI g) {
		list.add(g);
	}
	@Override
	public void remove(GUI g) {
		list.remove(g);
	}
	/**
	 * @param panelName
	 */
	public MiddlePanel(String panelName) {
		super();
		this.panelName = panelName;
	}

}
