package websocket;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by alongsea2 on 16/12/8.
 */
public class VncServerB {
    public static void main(String[] args) {

        try {
            ServerSocket serverSocket2 = new ServerSocket();
            serverSocket2.bind(new InetSocketAddress("localhost",53518));
            Socket client2 = serverSocket2.accept();

            while (true){

                try {
                    Thread.sleep(600);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                client2.getOutputStream().write(("test2").getBytes());

            }
        }catch (Exception e){

        }

    }
}
