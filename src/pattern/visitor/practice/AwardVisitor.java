package pattern.visitor.practice;

public abstract class AwardVisitor {
	public abstract void visit(Student s);
	public abstract void visit(Teacher t);
}
