package pattern.decorator;

public class Client {
	private enum  type{
	    TYPE,
	    FIELD,
	    METHOD
	}
	public static void main(String[] args) {
		Component box,list;
		box = new Box();
		list = new List();
		box.operation();
		list.operation();
		System.out.println(type.TYPE);
	}
}
