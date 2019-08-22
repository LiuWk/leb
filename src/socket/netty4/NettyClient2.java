package socket.netty4;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author lwk
 * @date 2019-08-21 11:14
 */
public class NettyClient2 {
    private static final Logger LOGGER = LoggerFactory.getLogger(NettyServer.class);

    public static void main(String[] args) {
        Bootstrap bootstrap = new Bootstrap();
        NioEventLoopGroup nioEventLoopGroup = new NioEventLoopGroup();
        try {
            bootstrap.group(nioEventLoopGroup)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<NioSocketChannel>() {
                        @Override
                        protected void initChannel(NioSocketChannel nioSocketChannel) throws Exception {
                            nioSocketChannel.pipeline().addLast(new LineBasedFrameDecoder(1024));
                            nioSocketChannel.pipeline().addLast(new StringEncoder(CharsetUtil.UTF_8));
                        }
                    });
            Channel channel = bootstrap.connect("127.0.0.1", 8001).channel();
            /**
             * 注意：连续发送报文，会产生粘包
             * 对于这样的问题只能通过上层的应用来解决，常见的方式有：
             *
             * 在报文末尾增加换行符表明一条完整的消息，这样在接收端可以根据这个换行符来判断消息是否完整。
             * 将消息分为消息头、消息体。可以在消息头中声明消息的长度，根据这个长度来获取报文（比如 808 协议）。
             * 规定好报文长度，不足的空位补齐，取的时候按照长度截取即可。
             *
             * 以上的这些方式我们在 Netty 的 pipline 中里加入对应的解码器都可以手动实现。
             * 但其实 Netty 已经帮我们做好了，完全可以开箱即用。
             * LineBasedFrameDecoder 可以基于换行符解决。
             * DelimiterBasedFrameDecoder可基于分隔符解决。
             * FixedLengthFrameDecoder可指定长度解决。
             */
            for (int i = 0; i < 5; i++) {
                String msg = RandomStringUtils.randomNumeric(10) + "\n";
                channel.writeAndFlush(msg);
                LOGGER.info("发送信息 msg：{}", msg);
                Thread.sleep(1000);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭线程组
            nioEventLoopGroup.shutdownGracefully();
        }

    }
}
