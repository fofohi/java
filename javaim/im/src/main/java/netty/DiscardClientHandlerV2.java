package netty;


import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.apache.log4j.Logger;


/**
 * Created by dell on 2016/7/15.
 */
public class DiscardClientHandlerV2 extends ChannelInboundHandlerAdapter {

    private static final Logger logger = Logger.getLogger(DiscardClientHandlerV2.class);


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        logger.info("===== V2 " + msg);
    }

}
