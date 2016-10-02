package im;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by xianyu on 2016/3/28.
 */
public class AppClient
{
    public static String id = UUID.randomUUID().toString();
    public static void main(String[] args)
    {
        Socket sc = new Socket();
        try {
            sc.connect(new InetSocketAddress(9999));
            sc.getOutputStream().write(("first:"+id).getBytes());
            new Thread(new HeartBagSend(sc)).start();
            new Thread(new reciveServer(sc)).start();

        } catch (IOException e) {
            try {
                sc.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}

class Heartbag{

    static byte[] sendHeartBag(String id) {
        return  (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+":"+id).getBytes();
    }
}

class HeartBagSend implements Runnable{
    private Socket socket;
    private boolean flag = true;
    public HeartBagSend(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            while (flag){
                OutputStream sgos = socket.getOutputStream();
                sgos.write(Heartbag.sendHeartBag(AppClient.id));
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    flag = false;
                    sgos.close();
                    System.out.println("连接关闭");
                }
            }
        } catch (IOException e) {
            flag = false;
            System.out.println("连接关闭");
        }
    }
}

class reciveServer implements Runnable{
    private Socket socket;
    public reciveServer(Socket socket) {
        this.socket = socket;
    }


    @Override
    public void run() {
        byte[] by = new byte[1024];
        try {
            InputStream sgis = socket.getInputStream();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(sgis);
            int n;
            while ((n = bufferedInputStream.read(by)) != -1)
            {
                System.out.println(new String(by,0,n));
            }
        } catch (IOException e) {

        }
    }
}
