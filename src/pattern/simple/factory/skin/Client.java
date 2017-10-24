package pattern.simple.factory.skin;

public class Client {
	public static void main(String[] args) throws ClassNotFoundException {
		SkinFactory skinFactory = (SkinFactory) XMLUtil.getBean();
		skinFactory.createButton().display();
		skinFactory.createTextField().display();
//		System.out.println(Client.class.getName().replace(Client.class.getSimpleName(), ""));
	}
}
