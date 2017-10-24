package pattern.command;

public class Invoke {
	private CommandQueue commandQueue;

	public Invoke(CommandQueue commandQueue) {
		super();
		this.commandQueue = commandQueue;
	}

	public void setCommandQueue(CommandQueue commandQueue) {
		this.commandQueue = commandQueue;
	}

	// 调用CommandQueue类的execute()方法
	public void call() {
		commandQueue.execute();
	}
}
