package pattern.command.memento;

public abstract class AbstractCommand {
	public abstract int execute(int value);
	public abstract int undo();
	public abstract int redo();
}
