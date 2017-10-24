package pattern.momento;

import pattern.momento.Chessman2.ChessmanMemento2;

public class Client2 {
	private static int index = -1;
	private static MementoCaretaker2 mc = new MementoCaretaker2();
	public static void main(String args[]) {
		Chessman2 chess = new Chessman2("车", 1, 1);
		display(chess);
		
	    chess.setX(2);
	    display(chess);
	    save(chess);//保存状态
	    
	    chess.setX(3);
	    display(chess);
	    save(chess);//保存状态
	    
	    chess.setX(4);
	    display(chess);
	    save(chess);//保存状态
	    
	    undo(chess, index);//恢复
	    undo(chess, index);//恢复
	    
	}

	public static void display(Chessman2 chess) {
		System.out.println("棋子" + chess.getLabel() + "当前位置为：" + "第 " + chess.getX()+"行 "+chess.getY()+"列");
	}
	
	public static void save(Chessman2 chess){
		ChessmanMemento2 c = chess.save();
		mc.setMemento2(c);
		index++;
		System.out.println("保存! 棋子" + chess.getLabel() + "当前位置为：" + "第 " + chess.getX()+"行 "+chess.getY()+"列");
	}
	
	public static void undo(Chessman2 chess, int i){
		ChessmanMemento2 c = mc.getMemento2(i-1);
		chess.restore(c);
		index--;
		System.out.println("撤销! 棋子" + chess.getLabel() + "当前位置为：" + "第 " + chess.getX()+"行 "+chess.getY()+"列");
	}
}
