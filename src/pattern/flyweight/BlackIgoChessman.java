package pattern.flyweight;

//黑色棋子类：具体享元类
class BlackIgoChessman extends IgoChessman {
	@Override
    public String getColor() {
		return "黑色";
	}
}