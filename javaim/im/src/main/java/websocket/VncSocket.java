package websocket;


import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by dell on 2016/11/25.
 */
public class VncSocket {


    private static ConcurrentHashMap<String,Dto> map = new ConcurrentHashMap<>();


    public static void main(String[] args) {
        try {
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress("localhost",53517));

            Socket socket2 = new Socket();
            socket2.connect(new InetSocketAddress("localhost",53518));

            Dto dto1 = new Dto();
            dto1.setPort(53517);
            dto1.setSocket(socket);

            Dto dto2 = new Dto();
            dto2.setPort(53518);
            dto2.setSocket(socket2);

            map.put("socket1",dto1);
            map.put("socket2",dto2);



            new Thread(new loopMapThread()).start();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class loopMapThread implements Runnable{
        private ExecutorService executorService  = Executors.newFixedThreadPool(10);

        @Override
        public void run() {
            while (true){

                for (Map.Entry<String, Dto> stringSocketEntry : map.entrySet()) {
                     Dto dto = stringSocketEntry.getValue();
                     Socket socket = dto.getSocket();
                     if (socket != null && socket.isConnected()){
                         executorService.execute(new WriteReadThread(dto));
                     }else{
                         //reconnect
                         Socket reSocket = new Socket();
                         try {
                             reSocket.connect(new InetSocketAddress("localhost",dto.getPort()));
                             dto.setSocket(reSocket);
                         } catch (IOException e) {
                             dto.setSocket(null);
                         }
                     }
                }
                try {
                   Thread.sleep(600);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

class Dto{
    private Socket socket;
    private int port;

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
