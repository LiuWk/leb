package socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import org.apache.log4j.Logger;

public class SocketClient {
	private Logger logger = Logger.getLogger(SocketClient.class);
	public Socket socket = null;
	private DataInputStream in = null;
	private DataOutputStream out = null;
	private String serverIp;
	private String port;
	private String timeout = "0";

	public SocketClient(String _serverIp, String _port) {
		this.serverIp = _serverIp;
		this.port = _port;
	}

	public void connect() throws IOException {
		if ((this.socket == null) && (this.in == null) && (this.out == null)) {
			this.socket = new Socket(this.serverIp, Integer.parseInt(this.port.trim()));
			this.in = new DataInputStream(this.socket.getInputStream());
			this.out = new DataOutputStream(this.socket.getOutputStream());
			this.socket.setSoTimeout(Integer.parseInt(this.timeout.trim()));
		}
	}

	public void sendMsg(String msg, String charEncoding) throws Exception {
		try {
			this.logger.debug("send message content is :" + msg + " used charEncoding is :" + charEncoding);

			byte[] sendbytes = msg.getBytes(charEncoding);
			sendMsg(sendbytes);
		} catch (IOException e) {
			e.printStackTrace();
			try {
				destory();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public void sendMsg(byte[] msg) throws Exception {
		try {
			if (this.out != null) {
				this.out.writeShort(msg.length);
				this.out.write(msg);
				this.logger.debug(" message have been sent");
				this.out.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
			try {
				destory();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public String receiveMsg(String charEncoding) throws Exception {
		String reeciveStr = null;
		try {
			int head = this.in.readShort();
			byte[] body = new byte[head];
			int readline = 0;
			int length = 0;
			while (length < head) {
				readline = this.in.read(body, length, body.length - length);
				length += readline;
			}
			reeciveStr = new String(body, charEncoding);
//			System.out.println(new String(Des3Util.decrypt(body)));
			this.logger.debug("soketClient receive mesg:" + reeciveStr + "  charEncoding: " + charEncoding);
		} catch (IOException e) {
			e.printStackTrace();
			try {
			} catch (Exception e2) {
			}
		} finally {
			destory();
		}
		return reeciveStr;
	}

	public void destory() {
		if (this.in != null) {
			try {
				this.in.close();
			} catch (Exception e) {
				// this.logger.error(LogFormat.formatError("destory", e,
				// "destory socket client erroe when close dateinputStream"));
			}
		}
		if (this.out != null) {
			try {
				this.out.close();
			} catch (Exception e) {
				// this.logger.error(LogFormat.formatError("destory", e,
				// "destory socket client erroe when close
				// BufferoutputStreamt"));
			}
		}
		if (this.socket != null) {
			try {
				this.socket.close();
			} catch (Exception e) {
				// this.logger.error(LogFormat.formatError("destory", e,
				// "destory socket client erroe when close socket"));
			}
		}
		this.logger.debug("socket client destoryed");
	}

	public boolean validateObject() {
		if ((this.socket != null) && (!this.socket.isClosed()) && (this.socket.isConnected())) {
			return true;
		}
		return false;
	}

	public String getTimeout() {
		return this.timeout;
	}

	public void setTimeout(String timeout) {
		this.timeout = timeout;
	}
}
