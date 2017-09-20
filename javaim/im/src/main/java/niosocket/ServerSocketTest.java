package niosocket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by sunzhuhuan Administrator on 2017/8/31.
 */
public class ServerSocketTest {

    public void startServer(){
        try {
            ServerSocket ss = new ServerSocket(8888);
            while (true){
                Socket clientSocket = ss.accept();

                new Thread(()->{
                    clientSocket


                }).start();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ServerSocketTest().startServer();
    }
}
