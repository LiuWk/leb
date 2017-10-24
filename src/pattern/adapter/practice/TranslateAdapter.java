package pattern.adapter.practice;

public class TranslateAdapter implements Operation{
	private ChineseToEnglish ce;
	@Override
	public void translate() {
		ce.translateC();
	}

}
