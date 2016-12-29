package niosocket;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by alongsea2 on 2016/12/22.
 */
public class Socket implements Runnable{
    private int port;
    private int index;

    private static ConcurrentHashMap<Integer, java.net.Socket> socketMap = new ConcurrentHashMap<>();
    private static List<Integer> list = new ArrayList<>();

    public Socket(int port,int index) {
        this.port = port;
        this.index = index;
    }

    public static void main(String[] args) {
        int index = 0;
        new Thread(new Socket(10801,index)).start();
//        for(int i = 10801;i<=10845;i++){
//            new Thread(new Socket(i,index)).start();
//            list.add(index);
//            index++;
//        }
        int allSocket = 45;
        int allHandler = 9;
        int allInfinite = allSocket / allHandler;
        new Thread(new InfiniteThread(0,1)).start();
//        for(int j = 0; j < allInfinite; j++){
//            new Thread(new InfiniteThread(j,allHandler)).start();
//        }

    }

    private void connectSocket() throws IOException {
        java.net.Socket socket = new java.net.Socket();
        socket.connect(new InetSocketAddress("localhost",port));
        socketMap.put(index,socket);
    }

    @Override
    public void run() {
        try {
            connectSocket();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class InfiniteThread implements Runnable{

        private int begin;
        private int end;


        public InfiniteThread(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }

        @Override
        public void run() {

            while (true){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ConcurrentHashMap<Integer, java.net.Socket> map = socketMap;
                for(int z = begin * end  ; z < (begin + 1) * end ; z++){
                    try {
                        Integer fx = list.get(z);
                        if(fx == null) continue;
                        java.net.Socket socket = map.get(fx);
                        if(socket == null)continue;

                        if(socket.isConnected()){
                            long be = System.currentTimeMillis();
                            byte[] br = new byte[4];
                            socket.getInputStream().read(br,0,4);
                            int r = ((br[0] & 0xFF ) << 24 ) | ((br[1] & 0xFF) << 16) | ((br[2] & 0xFF) << 8 ) | ((br[3] & 0xFF) << 0);
                            byte[] b = new byte[r];
                            socket.getInputStream().read(b);
                            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(b);
                            BufferedImage image = ImageIO.read(byteArrayInputStream);
                            Image fxImage = SwingFXUtils.toFXImage(image,null);
                            System.out.println(fxImage);
                            System.out.println(System.currentTimeMillis() - be);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
