package pattern.command.memento;

public class ConcreteCommand extends AbstractCommand {
	private Adder add = new Adder();
	private int value;
	@Override
	public int execute(int value) {
		this.value = value;
		return add.add(value);
	}

	@Override
	public int undo() {//撤销
		return add.add(-value);
	}

	@Override
	public int redo() {//恢复
		return add.add(value);
	}

}
