package pattern.command.memento;

public class CalculatorForm {
	private AbstractCommand command;

	public void setCommand(AbstractCommand command) {
		this.command = command;
	}
	
	public void compute(int value){
		int i = command.execute(value);
		System.out.println("计算结果为："+i);
	}
	public void undo(){
		int i = command.undo();
		System.out.println("执行撤销，结果为："+i);
	}
	public void redo(){
		int i = command.redo();
		System.out.println("恢复撤销，结果为："+i);
	}
	
}

