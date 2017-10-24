package pattern.momento;

import java.util.ArrayList;
import java.util.List;

///象棋棋子类：原发器s
public class Chessman {
	private String label;
	private int x;
	private int y;

	public Chessman(String label, int x, int y) {
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
	public ChessmanMemento save() {
		ChessmanMemento e = new ChessmanMemento(this.label, this.x, this.y);
		return e;
	}

	// 恢复状态
	public void restore(ChessmanMemento memento) {
		this.label = memento.getLabel();
		this.x = memento.getX();
		this.y = memento.getY();
	}
}

// 象棋棋子备忘录类：备忘录
class ChessmanMemento {
	private String label;
	private int x;
	private int y;

	public ChessmanMemento(String label, int x, int y) {
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

// 象棋棋子备忘录管理类：负责人
class MementoCaretaker {
	private List<ChessmanMemento> list = new ArrayList<>();
	private ChessmanMemento memento;

	public ChessmanMemento getMemento() {
		return memento;
	}
	
	public ChessmanMemento getMemento(int i) {
		return list.get(i);
	}

	public void setMemento(ChessmanMemento memento) {
		this.memento = memento;
	}
}