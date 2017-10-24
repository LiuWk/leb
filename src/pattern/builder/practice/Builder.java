package pattern.builder.practice;

public abstract class Builder {
	Equipment eq = new Equipment();

	public abstract void buildJersey();

	public abstract void buildShoes();

	public abstract void buildColor();

	public abstract void buildSize();

	public Equipment getResult() {
		return eq;
	}
}
