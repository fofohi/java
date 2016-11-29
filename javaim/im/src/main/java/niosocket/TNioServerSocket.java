package niosocket;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;

/**
 * Created by alongsea2 on 16/11/28.
 */
public class TNioServerSocket {

    public static void main(String[] args) {

        try {
            ServerSocketChannel o = ServerSocketChannel.open();
            o.bind(new InetSocketAddress(9091));
            o.configureBlocking(false);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
