package im;

import java.io.*;
import java.net.URL;

/**
 * Created by alongsea2 on 2016/12/20.
 */
public class ReadFileThread implements Runnable{

    private String fileName;

    public ReadFileThread(String fileName) {
        this.fileName = fileName;

    }

    @Override
    public void run() {
        try {
            String fileUrl = ReadFileThread.class.getClassLoader().getResource("200.png").getPath();

            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File(fileUrl)));
            byte[] bt = new byte[128];
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(fileName));
            while (bis.read(bt,0,128) != - 1){
                bos.write(bt,0,128);
            }
            bos.close();
            System.out.println(fileName + "ok");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new ReadFileThread("t1.png"));
        Thread t2 = new Thread(new ReadFileThread("t2.png"));
        Thread t3 = new Thread(new ReadFileThread("t3.png"));


        t1.start();
//        t1.join();
//        t2.start();
//        t2.join();
//        t3.start();
        //t3.join();
    }
}
