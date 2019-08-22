package socket.netty4;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
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
public class NettyClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(NettyServer.class);

    public static void main(String[] args) {
        Bootstrap bootstrap = new Bootstrap();
        NioEventLoopGroup nioEventLoopGroup = new NioEventLoopGroup();
        try {
            bootstrap.group(nioEventLoopGroup)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ChannelInitializer<NioSocketChannel>() {
                        @Override
                        protected void initChannel(NioSocketChannel nioSocketChannel) throws Exception {
                            nioSocketChannel.pipeline().addLast(new LineBasedFrameDecoder(1024));
                            nioSocketChannel.pipeline().addLast(new StringEncoder(CharsetUtil.UTF_8));
                        }
                    });
            Channel channel = bootstrap.connect("127.0.0.1", 8001).channel();
            for (int i = 0; i < 5; i++) {
                String msg = RandomStringUtils.randomAlphabetic(10) + "\n";
                channel.writeAndFlush(msg.trim());
                LOGGER.info("发送信息 msg：{}", msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭线程组
            nioEventLoopGroup.shutdownGracefully();
        }

    }
}
