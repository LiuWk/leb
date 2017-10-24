package pattern.builder.practice;

public class ItalyBuilder extends Builder {

	@Override
	public void buildJersey() {
		Jersey jersey = new Jersey("Italy");
		eq.setJersey(jersey);
	}

	@Override
	public void buildShoes() {
		Shoes shoes = new Shoes("Italy");
		eq.setShoes(shoes);
	}

	@Override
	public void buildColor() {
		eq.setColor("blue");
	}

	@Override
	public void buildSize() {
		eq.setSize("L");
	}

}
