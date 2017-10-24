package pattern.builder;

public class Product {
	private String partA; // 定义部件，部件可以是任意类型，包括值类型和引用类型
	private String partB;
	private String partC;
	// partA的Getter方法和Setter方法省略
	// partB的Getter方法和Setter方法省略
	// partC的Getter方法和Setter方法省略
}

 abstract class Builder {
	// 创建产品对象
	protected Product product = new Product();

	public abstract void buildPartA();

	public abstract void buildPartB();

	public abstract void buildPartC();

	// 返回产品对象
	public Product getResult() {
		return product;
	}
}

class Director {
	private Builder builder;

	public Director(Builder builder) {
		this.builder = builder;
	}

	public void setBuilder(Builder builder) {
		this.builder = builder;
	}

	// 产品构建与组装方法
	public Product construct() {
		builder.buildPartA();
		builder.buildPartB();
		builder.buildPartC();
		return builder.getResult();
	}
}