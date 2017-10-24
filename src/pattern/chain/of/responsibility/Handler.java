package pattern.chain.of.responsibility;

abstract class Handler {
	// 维持对下家的引用
	protected Handler successor;

	public void setSuccessor(Handler successor) {
		this.successor = successor;
	}

	public abstract void handleRequest(String request);
}
