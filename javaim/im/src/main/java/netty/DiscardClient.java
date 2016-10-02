package netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

/**
 * Created by dell on 2016/7/15.
 */
public class DiscardClient {
    static final int SIZE = Integer.parseInt(System.getProperty("size", "256"));

    public static void main(String[] args) {
        Bootstrap bootstrap = new Bootstrap();
        bootstrap
                .group(new NioEventLoopGroup())
                .channel(NioSocketChannel.class)
                .option(ChannelOption.TCP_NODELAY,true)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        ChannelPipeline p = socketChannel.pipeline();
                        p.addLast(new StringDecoder());
                        p.addLast(new DiscardClientHandler());
                        p.addLast(new DiscardClientHandlerV2());
                        p.addLast(new StringEncoder());

                    }
                });
        try {
            bootstrap.connect("localhost", 18080).sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
