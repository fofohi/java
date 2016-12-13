package websocket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by alongsea2 on 16/11/25.
 */
public class VncSocketThreadController {


    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress("localhost",53517));



                Socket client = serverSocket.accept();

                while (true){

                    try {
                        Thread.sleep(600);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    client.getOutputStream().write("test1".getBytes());

                }





        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
