package niosocket;

import java.io.*;
import java.net.InetSocketAddress;

/**
 * Created by alongsea2 on 2016/12/22.
 */
public class ServerSocket implements Runnable{

    private int port;

    public ServerSocket(int port) {
        this.port = port;
    }

    public static void main(String[] args) {
        new Thread(new ServerSocket(18080)).start();
//        for(int i = 10801 ; i<= 10845 ; i++){
//            new Thread(new ServerSocket(i)).start();
//        }
    }

    private void runServer() throws IOException {
        java.net.ServerSocket serverSocket = new java.net.ServerSocket();
        serverSocket.bind(new InetSocketAddress("localhost",port));
        java.net.Socket s = serverSocket.accept();
        System.out.println(port + " server is connect");
        InputStream input1 = s.getInputStream();
        while (true){
            try {
               /* Thread.sleep(500);
                FileInputStream file = new FileInputStream(new File(this.getClass().getResource("../200.png").getPath()));
                int fileLength = file.available();
                byte[] fileByte = new byte[fileLength];
                file.read(fileByte,0,fileLength);
                int sendLength = fileByte.length;*/
//                BufferedReader reader = new BufferedReader(new InputStreamReader(input1));
//                System.out.println(reader.readLine());
                int i ;
                int motion = input1.read();
                System.out.println((char)motion);
                int motionType = input1.read();
                System.out.println((char)motionType);
                int length = input1.read();
                System.out.println(length);

                byte[] b = new byte[length];

                while ( (i = input1.read(b) ) == -1 ){
                    break;
                }
                System.out.println(new String(b));
//                byte[] bl = new byte[4];
//                bl[0] = (byte) (( sendLength >>> 24 ) & 0xFF);
//                bl[1] = (byte) (( sendLength >>> 16 ) & 0xFF);
//                bl[2] = (byte) (( sendLength >>> 8 ) & 0xFF);
//                bl[3] = (byte) (( sendLength >>> 0 ) & 0xFF);

               /* s.getOutputStream().write(bl);
                s.getOutputStream().write(fileByte);*/
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void run() {
        try {
            runServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
