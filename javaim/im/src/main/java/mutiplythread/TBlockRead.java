package mutiplythread;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by alongsea2 on 16/12/3.
 */
public class TBlockRead {

    public static void main(String[] args) {
        ReadThread rt = null;
        for(int i = 0;i<45;i++){
            rt = new ReadThread();
            new Thread(rt).start();
        }
        new Thread(new WriteThread(rt.getLinkedBlockingQueue())).start();
    }
}

class WriteThread implements Runnable{
    public LinkedBlockingQueue linkedBlockingQueue;

    WriteThread(LinkedBlockingQueue q){
        this.linkedBlockingQueue = q;
    }

    @Override
    public void run() {
        InputStream inConsole = System.in;
        System.out.println(Thread.currentThread().getName());
        int n = 0;
        try {
            while (true){

                //String s = (char) n + "";
                linkedBlockingQueue.offer("s");
                wait();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class ReadThread implements Runnable{
    public LinkedBlockingQueue linkedBlockingQueue =  new LinkedBlockingQueue();
    @Override
    public void run() {
        while (true){
            //for(int i = 0;i< 100;i++){
                try {
                    System.out.println(Thread.currentThread().getName());
                    Object t = linkedBlockingQueue.take();

                    System.out.println(t);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            //}
        }
    }

    public LinkedBlockingQueue getLinkedBlockingQueue() {
        return linkedBlockingQueue;
    }

}