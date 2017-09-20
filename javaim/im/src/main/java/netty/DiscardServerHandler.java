package netty;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.ReferenceCountUtil;
import org.apache.log4j.Logger;
import util.ChannelHashMap;


import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**x
 * Created by dell on 2016/7/15.
 */
public class DiscardServerHandler extends ChannelInboundHandlerAdapter { // (1)

    private static final Logger logger = Logger.getLogger(DiscardServerHandler.class);


    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        //连接成功返回client成功
        String welcome = "from server welcome";
        ctx.writeAndFlush(welcome);
        ReferenceCountUtil.release(welcome);
    }


    @Override
    public void channelRead(ChannelHandlerContext serverCtx, Object msg) {
        logger.info("====>" + msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {


    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if(IdleStateEvent.class.isAssignableFrom(evt.getClass())){
            IdleStateEvent event = (IdleStateEvent) evt;
            if(event.state() == IdleState.WRITER_IDLE){
                logger.info("==== write heart");
            }else if(event.state() == IdleState.READER_IDLE){
                logger.info("==== read heart");
            }else if (event.state() == IdleState.ALL_IDLE){
                logger.info("==== write read heart");
            }
        }

    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) { // (4)
        // Close the connection when an exception is raised.
        logger.error(cause.getMessage());
        ctx.close();
    }
}
