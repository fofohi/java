package netty;


import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
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
        logger.info("===== client active ok" );
        //注册自己的状态给服务器
        //开启读写线程
        new writeMsgThread(ctx);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        logger.info("===== " + msg);
        ctx.fireChannelRead(msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {

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
                    ctx.channel().write(message);
                    ctx.flush();
                }
            }
        }
    }

}
