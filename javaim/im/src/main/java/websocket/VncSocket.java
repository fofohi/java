package websocket;

import com.koushikdutta.async.AsyncNetworkSocket;
import com.koushikdutta.async.AsyncSocket;
import com.koushikdutta.async.http.socketio.SocketIORequest;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Created by dell on 2016/11/25.
 */
public class VncSocket {

    private static InputStream inputStream;
    private static OutputStream outputStream;

    public static void main(String[] args) {
        try {
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress("192.168.60.180",53517));
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
            byte[] bt = new byte[1024 * 10];
            while (true){
                int input = inputStream.read(bt);
                while (input != -1){
                    System.out.println(input);
                    System.out.println(bt.length);
                    System.out.println(new String(bt));
                    outputStream.write(("from client").getBytes());
                    outputStream.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testFunc(){

    }
}
