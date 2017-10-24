package pattern.builder.practice;

public class Director {
	private Builder builder;

	public Director(Builder builder) {
		this.builder = builder;
	}

	public void setBuilder(Builder builder) {
		this.builder = builder;
	}

	// 产品构建与组装方法
	public Equipment construct() {
		builder.buildJersey();
		builder.buildShoes();
		builder.buildColor();
		builder.buildSize();
		return builder.getResult();
	}
}
