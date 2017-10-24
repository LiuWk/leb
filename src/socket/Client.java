package socket;

import org.apache.log4j.Logger;

public class Client {
	private static final Logger log = Logger.getLogger(Client.class);
	private static final String IP = "127.0.0.1";
	private static final String PORT = "8000";
	
	private static String sendMessage(String sendMsg) throws Exception {
		// 创建Socket客户端
		SocketClient client = null;
		String result = "";
		try {
			log.info( "Client.sendMessage sendMsg "+sendMsg );
			client = new SocketClient(IP, PORT);
			// 客户端连接Server
			client.connect();
			// 超时时间
			client.setTimeout("10000");
			// 向Server发送报文
			client.sendMsg(sendMsg, "UTF-8");
			// 接收Server的回执报文
			result = client.receiveMsg("UTF-8");
			log.info("Client.sendMessage result "+ result );
		} catch (Exception e) {
			log.info("Client.sendMessage 发送请求出错", e);
		} finally {
			if (client != null)
				client.destory();
		}
		return result;
	}
	
	public static void main(String[] args) throws Exception {
		
		sendMessage("301002;7701;");
	}
}
