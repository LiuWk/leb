package pattern.momento;

//备忘录类，默认可见性，包内可见
public class Memento {
	private String state;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Memento(Originator originator) {
		super();
		this.state = originator.getState();
	}

}
