package netty;


import io.netty.buffer.*;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by dell on 2016/7/15.
 */
public class DiscardClientHandler extends ChannelInboundHandlerAdapter {

    private static final Logger logger = Logger.getLogger(DiscardClientHandler.class);

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        ctx.writeAndFlush("v1 give from client");
        new writeMsgThread(ctx);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        logger.info("v1 channelRead ===== " + msg);
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
    public void exceptionCaught(ChannelHandlerContext ctx,Throwable th){
        th.printStackTrace();
        ctx.close();
    }

    private class writeMsgThread implements Runnable{

        private String message = "";
        private ChannelHandlerContext ctx;


        writeMsgThread(ChannelHandlerContext ctx) {
          this.ctx = ctx;
          new Thread(this).start();
        }

        @Override
        public void run() {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            while(true) {
                try {
                    message = in.readLine();
                } catch (IOException e) {
                    message = "";
                }
                if(!message.isEmpty()) {
                    message = ctx.toString() + "[client say] " + message + "\r\n";
                    String s = "101,202";
                    ByteBuf a = Unpooled.directBuffer(4);
                    int sLength = s.length();
                    //ctx.channel().writeAndFlush("2\n");
                    //ByteBuf a = ctx.alloc().buffer(4);
                    ByteBuf r = a.writeByte(sLength);
                    ctx.channel().writeAndFlush("2");
                    ctx.channel().writeAndFlush("d");
                    ctx.channel().writeAndFlush(message);
                    ctx.channel().writeAndFlush(s);

                }
            }
        }
    }

}
