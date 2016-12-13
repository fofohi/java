package niosocket;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * Created by alongsea2 on 16/11/28.
 */
public class TNioSocket implements Runnable{
    public static void main(String[] args) {
        new Thread(new TNioSocket()).start();
    }

    @Override
    public void run() {
        try {
            startClient();
        }catch (Exception e){
            System.out.println("====>" + e);
        }
    }


    private void startClient() throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        socketChannel.connect(new InetSocketAddress("localhost",9091));

        Selector selector = Selector.open();
        socketChannel.register(selector, SelectionKey.OP_CONNECT);

        while (true){
            Iterator<SelectionKey> keys = selector.selectedKeys().iterator();

            while (keys.hasNext()){
                SelectionKey selectorKey = keys.next();
                keys.remove();

                if(selectorKey.isConnectable()){

                    if(socketChannel.isConnected()){
                        socketChannel.finishConnect();
                    }

                    SocketChannel serverChannel = (SocketChannel) selectorKey.channel();
                    serverChannel.configureBlocking(false);
                    serverChannel.register(selector,SelectionKey.OP_WRITE);
                }else if(selectorKey.isWritable()){
                    SocketChannel serverChannel = (SocketChannel) selectorKey.channel();
                    serverChannel.configureBlocking(false);
                    serverChannel.write(ByteBuffer.wrap("clienttest".getBytes()));
//                    int i = serverChannel.read(ByteBuffer.allocate(10));
//                    System.out.println(i);
                }

            }
        }
    }
}
