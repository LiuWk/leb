package pattern.command;

import java.util.ArrayList;
import java.util.List;

public class CommandQueue {
	//命令列表
	private static List<Command> commands = new ArrayList<>();
	//增加命令
	public void addCommand(Command c){
		commands.add(c);
	}
	//删除命令
	public void removeCommand(Command c){
		commands.remove(c);
	}
	
	//执行所有命令
	public void execute(){
		for(Command c : commands){
			c.execute();
		}
	}
}
