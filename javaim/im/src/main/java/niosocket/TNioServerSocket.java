package niosocket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * Created by alongsea2 on 16/11/28.
 */
public class TNioServerSocket implements Runnable{


    private ServerSocketChannel ssc;
    private Selector selector;



    public static void main(String[] args) {
        new Thread(new TNioServerSocket()).start();
    }

    private void startServer() throws IOException {
        boolean someFlag = true;
        //socket open
        ssc = ServerSocketChannel.open();
        //socket bind port
        ssc.socket().bind(new InetSocketAddress(9091));
        //set none-block
        ssc.configureBlocking(false);
        //get selector
        selector = Selector.open();
        //register selector accept event
        ssc.register(selector, SelectionKey.OP_ACCEPT);

        //loop
        while (someFlag){
            //block
            int selectorNum = selector.select();


            if(selectorNum > 0){

                Iterator<SelectionKey> keys = selector.selectedKeys().iterator();

                while (keys.hasNext()){

                    SelectionKey selectorKey = keys.next();
                    keys.remove();

                    if(selectorKey.isAcceptable()){
                        SocketChannel socketChannel = ssc.accept();
                        socketChannel.configureBlocking(false);
                        socketChannel.register(selector,SelectionKey.OP_READ);
                        System.out.println("====>" + socketChannel);
                    }else if(selectorKey.isReadable()){
                        SocketChannel sc = (SocketChannel)selectorKey.channel();
                        sc.configureBlocking(false);
                        sc.write(ByteBuffer.wrap("servertest".getBytes()));

                    }

                }
            }
        }
    }


    @Override
    public void run() {
        try {
            startServer();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
