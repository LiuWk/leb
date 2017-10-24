package pattern.simple.factory.skin;

//Spring皮肤工厂：具体工厂
public class SpringSkinFactory implements SkinFactory {

	@Override
	public Button createButton() {
		return new SpringButton();
	}

	@Override
	public TextField createTextField() {
		return new SpringTextField();
	}

}

// Summer皮肤工厂：具体工厂
class SummerSkinFactory implements SkinFactory {
	@Override
	public Button createButton() {
		return new SummerButton();
	}

	@Override
	public TextField createTextField() {
		return new SummerTextField();
	}

}