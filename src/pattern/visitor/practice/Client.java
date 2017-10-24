package pattern.visitor.practice;

import pattern.template.XMLUtil;

public class Client {
	public static void main(String[] args) {
		Person p1,p2,p3,p4;
		PersonList list = new PersonList();
		p1 = new Student("AA", 10, 100);
		p2 = new Student("BB", 2, 80);
		p3 = new Student("CC", 0, 100);
		p4 = new Teacher("DD", 22, 91);
		list.addPerson(p1);
		list.addPerson(p2);
		list.addPerson(p3);
		list.addPerson(p4);
		AwardVisitor v = (AwardVisitor) XMLUtil.getBean(3);
		list.accept(v);
	}
}
