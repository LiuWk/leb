package pattern.builder.practice;

public class Equipment {
	private String size;
	private String color;
	private Jersey jersey;
	private Shoes shoes;

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Jersey getJersey() {
		return jersey;
	}

	public void setJersey(Jersey jersey) {
		this.jersey = jersey;
	}

	public Shoes getShoes() {
		return shoes;
	}

	public void setShoes(Shoes shoes) {
		this.shoes = shoes;
	}

}
