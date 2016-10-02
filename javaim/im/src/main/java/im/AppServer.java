package im;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;


/**
 *
 *
 */
public class AppServer
{
    private static Set<Socket> onlineList = new HashSet<Socket>();
    private ServerSocket serverSocket;
    public AppServer() {
        try {
            int port = 9999;
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    private static class ReceiveHandleThread implements Runnable{
        private Socket ss;
        public ReceiveHandleThread(Socket ss) {
            this.ss = ss;
        }
        @Override
        public void run() {
            byte[] by = new byte[1024*1024];
            int n;
            InputStream fcgi = null;
            try {
                fcgi = ss.getInputStream();
                BufferedInputStream bufferedInputStream = new BufferedInputStream(fcgi);
                while ((n = bufferedInputStream.read(by)) != -1) {
                    String connectStr = new String(by,0,n);
                    System.out.println("===服务器收到的消息:"+connectStr+"====");
                    for (Socket sockets : onlineList) {
                        sockets.getOutputStream().write(connectStr.getBytes());
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args )
    {
        AppServer appServer = new AppServer();
        while (true){
            try {
                Socket socket = appServer.getServerSocket().accept();
                onlineList.add(socket);
                new Thread(new ReceiveHandleThread(socket)).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
