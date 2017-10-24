package pattern.momento;

import java.util.ArrayList;
import java.util.List;

import pattern.momento.Chessman2.ChessmanMemento2;

//象棋棋子备忘录管理类：负责人
public class MementoCaretaker2 {
	private List<ChessmanMemento2> list = new ArrayList<>();
	public ChessmanMemento2 getMemento2(int i) {
		return list.get(i);
	}
	public void setMemento2(ChessmanMemento2 memento2) {
		list.add(memento2);
	}

	
}
