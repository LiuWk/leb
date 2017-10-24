package pattern.compent.practice;

public class Client {
	public static void main(String[] args) {
		GUI g1,g2,g3,form;
		g1 = new Button("确定");
		g2 = new CheckBox("选择");
		g3 = new TextBox("");
		form = new Form("聊天窗");
		form.add(g1);
		form.add(g2);
		form.add(g3);
	}
}
