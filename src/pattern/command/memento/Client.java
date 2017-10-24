package pattern.command.memento;

public class Client {
	public static void main(String[] args) {
		CalculatorForm form = new CalculatorForm();
		AbstractCommand command = new ConcreteCommand();
		form.setCommand(command);
		
		form.compute(10);
		form.compute(10);
		form.compute(10);
		form.undo();
		form.redo();
	}
}
