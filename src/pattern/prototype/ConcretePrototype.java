package pattern.prototype;

public class ConcretePrototype implements Prototype{

	@Override
	public void display() {
		System.out.println("ConcretePrototype display.");
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
