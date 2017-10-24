package socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * leb测试用源代码
 * 
 * 项目名称 : design_patterns
 * 创建日期 : 2017年8月21日
 * 类  描  述 : //TODO 添加类/接口功能描述
 * 修改历史 : 
 *     1. [2017年8月21日]创建文件 by lwk
 */
public class SocketServer {
    private ServerSocket server = null;

    public SocketServer() {
        try {
            server = new ServerSocket(8000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void init() {
        Socket socket = null;
        try {
            socket = server.accept();
            // 线程池替代
//            new Thread(new SocketServiceHandler(socket)).start();
            new ThreadPoolHandler(new SocketServiceHandler(socket));

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(server != null){
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            server = null;
        }
    }

    public static void main(String[] args) {
        new SocketServer().init();
    }
}
