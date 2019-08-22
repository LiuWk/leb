package socket.netty4;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.util.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author lwk
 * @date 2019-08-21 11:00
 */
public class NettyServer {
    private static final Logger LOGGER = LoggerFactory.getLogger(NettyServer.class);

    public static void main(String[] args) {
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        // 主线程组，用于接收客户端的链接，不做其他处理（相当于线程池）
        NioEventLoopGroup parent = new NioEventLoopGroup();
        // 子线程组，主线程组会把任务交给子线程组处理
        NioEventLoopGroup children = new NioEventLoopGroup();
        try {
            serverBootstrap.group(parent, children)
                    // 设置nio双向通道
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 1024)
                    .childHandler(new ChannelInitializer<NioSocketChannel>() {
                        @Override
                        protected void initChannel(NioSocketChannel nioSocketChannel) {
                            nioSocketChannel.pipeline().addLast(new StringDecoder(CharsetUtil.UTF_8));
                            nioSocketChannel.pipeline().addLast(new SimpleChannelInboundHandler<String>() {

                                @Override
                                protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {

                                    LOGGER.info("接收到消息msg：{}，发送人：{}", msg.trim(), ctx.channel().id());
                                }
                            });
                        }
                    });
            // 异步，syn（）为同步
            ChannelFuture channelFuture = serverBootstrap.bind(8001);
        } catch (Exception e) {
            e.printStackTrace();
            parent.shutdownGracefully();
            children.shutdownGracefully();
        }
        System.out.println("server start");
    }
}
