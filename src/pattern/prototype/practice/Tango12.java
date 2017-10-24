package pattern.prototype.practice;

public class Tango12 implements Cloneable {
	private String prize;
	private String color;

	public String getPrize() {
		return prize;
	}

	public void setPrize(String prize) {
		this.prize = prize;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Tango12 [prize=" + prize + ", color=" + color + "]";
	}

	@Override
	public Tango12 clone() {
		try {
			return (Tango12) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}


}
