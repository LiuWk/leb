package pattern.builder.practice;

public class SpainBuilder extends Builder {

	@Override
	public void buildJersey() {
		Jersey jersey = new Jersey("Spain");
		eq.setJersey(jersey);
	}

	@Override
	public void buildShoes() {
		Shoes shoes = new Shoes("Spain");
		eq.setShoes(shoes);
	}

	@Override
	public void buildColor() {
		eq.setColor("red");
	}

	@Override
	public void buildSize() {
		eq.setSize("XL");
	}
 

}
