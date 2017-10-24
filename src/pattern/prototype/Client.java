package pattern.prototype;

import pattern.prototype.practice.Tango12;

public class Client {
	public static void main(String[] args) {
		Prototype p1 = new ConcretePrototype();
		Prototype p2 = new ConcretePrototype2();
		System.out.println(p1.getClass() + "," + p2.getClass());
		System.out.println(p1.clone().getClass() + "," + p2.clone().getClass());
		System.out.println(p1 == p1.clone());
		System.out.println(p1.getClass() == p1.clone().getClass());
		System.out.println("-------------------------------------");
		
		Tango12 t = new Tango12();
		t.setColor("black white");
		t.setPrize("500￥");
		Tango12 t2 = t.clone();
		t2.setPrize("499￥");
		
		System.out.println(t);
		System.out.println(t2);
	}
}
