package socket.netty;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;
import org.jboss.netty.handler.codec.serialization.ClassResolvers;
import org.jboss.netty.handler.codec.serialization.ObjectDecoder;

public class HelloServer {

	public static void main(String[] args) {
		
		//server服务启动器
		ServerBootstrap sbs = new ServerBootstrap(new NioServerSocketChannelFactory(
				Executors.newCachedThreadPool(), 
				Executors.newCachedThreadPool()));
		
		 // 设置一个处理客户端消息和各种消息事件的类(Handler)  
		sbs.setPipelineFactory(new ChannelPipelineFactory() {
			
			@Override
			public ChannelPipeline getPipeline() throws Exception {
//				return Channels.pipeline(new HelloServerHandler());
				return Channels.pipeline(new ObjectDecoder(
						ClassResolvers.cacheDisabled(this.getClass().getClassLoader())),
						new ObjectServerHandler());
			}
		});
		
		//开放8000端口供客户端访问。  
		sbs.bind(new InetSocketAddress(8000));
	}
	
	private static class ObjectServerHandler extends SimpleChannelHandler{

		@Override
		public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
			// TODO Auto-generated method stub
			super.messageReceived(ctx, e);
			Command cmd = (Command) e.getMessage();
			System.out.println(cmd.getActionName());
		}
		
	}

	private static class HelloServerHandler extends SimpleChannelHandler {
		
		/**
		 * 当有客户端绑定到服务端的时候触发，打印"Hello world, I'm server."
		 */
		@Override
		public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e) {
			System.out.println("Hello world, I'm server.");
		}
	}
}
