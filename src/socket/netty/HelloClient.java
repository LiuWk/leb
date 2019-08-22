package socket.netty;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.SimpleChannelHandler;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;
import org.jboss.netty.handler.codec.serialization.ObjectEncoder;

/**
 * 有点问题，用的是jboss的netty包
 */
@Deprecated
public class HelloClient {

	public static void main(String[] args) {

		// Client服务启动器
		ClientBootstrap cbs = new ClientBootstrap(new NioClientSocketChannelFactory(
				Executors.newCachedThreadPool(),
				Executors.newCachedThreadPool()));
		// 设置一个处理服务端消息和各种消息事件的类(Handler)  
		cbs.setPipelineFactory(new ChannelPipelineFactory() {
			
			@Override
			public ChannelPipeline getPipeline() throws Exception {
//				return Channels.pipeline(new HelloClientHandler());
				return Channels.pipeline(new ObjectEncoder(),new ObjectClientHandler());
			}
		});
		 // 连接到本地的8000端口的服务端  
		cbs.connect(new InetSocketAddress("127.0.0.1", 8000));

	}
	private static class ObjectClientHandler extends SimpleChannelHandler{

		@Override
		public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
			// TODO Auto-generated method stub
			super.channelConnected(ctx, e);
			// 向服务端发送Object信息
	        sendObject(e.getChannel());
		}
		/**
	     * 发送Object
	     */
	    private void sendObject(Channel channel) {
	        Command command =new Command();
	        command.setActionName("Hello action.");
	        channel.write(command);
	    }
		
	}
	private static class HelloClientHandler extends SimpleChannelHandler {  
		  
		  
        /** 
         * 当绑定到服务端的时候触发，打印"Hello world, I'm client." 
         *  
         */  
        @Override  
        public void channelConnected(ChannelHandlerContext ctx,
									 ChannelStateEvent e) {
            System.out.println("Hello world, I'm client.");  
        }  
    }  
}
