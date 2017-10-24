package pattern.momento;

import java.util.ArrayList;
import java.util.List;


///象棋棋子类：原发器s
public class Chessman2 {
	private String label;
	private int x;
	private int y;

	public Chessman2(String label, int x, int y) {
		this.label = label;
		this.x = x;
		this.y = y;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	// 保存状态
	public ChessmanMemento2 save() {
		ChessmanMemento2 e = new ChessmanMemento2(this.label, this.x, this.y);
		return e;
	}

	// 恢复状态
	public void restore(ChessmanMemento2 memento) {
		this.label = memento.getLabel();
		this.x = memento.getX();
		this.y = memento.getY();
	}
	

	class ChessmanMemento2{
		private String label;
		private int x;
		private int y;

		public ChessmanMemento2(String label, int x, int y) {
			this.label = label;
			this.x = x;
			this.y = y;
		}

		public String getLabel() {
			return label;
		}

		public void setLabel(String label) {
			this.label = label;
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}
}
	
}

// 象棋棋子备忘录类：备忘录
/*class ChessmanMemento2 {
	private String label;
	private int x;
	private int y;

	public ChessmanMemento2(String label, int x, int y) {
		this.label = label;
		this.x = x;
		this.y = y;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}*/

