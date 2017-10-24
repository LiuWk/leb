package pattern.visitor.practice;

import java.util.ArrayList;
import java.util.List;

public class PersonList {
	public List<Person> list = new ArrayList<>();

	public void addPerson(Person p) {
		list.add(p);
	}
	// 遍历访问集合中的每一个员工对象
	public void accept(AwardVisitor v){
		for(Person p : list){
			p.accept(v);
		}
	}
}
