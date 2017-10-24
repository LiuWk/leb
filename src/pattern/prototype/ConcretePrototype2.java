package pattern.prototype;

public class ConcretePrototype2 implements Prototype{

	@Override
	public void display() {
		System.out.println("ConcretePrototype2 display.");
	}

	@Override
	public Prototype clone() {
		Object obj = null;
		try {
			obj = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return (Prototype) obj;
	}
	

}
