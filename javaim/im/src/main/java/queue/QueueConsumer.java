package queue;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by dell on 2016/5/18.
 */
public class QueueConsumer extends Thread {
    private LinkedBlockingQueue<QueueTask> queue;

    QueueConsumer(LinkedBlockingQueue<QueueTask> queue){
        this.queue = queue;
    }

    public void init(){
        super.start();
    }

    @Override
    public void run() {
        try {
            while (true){
                Thread.sleep(500);
                queue.take();
                System.out.println(Thread.currentThread().getName());
                System.out.println(queue.size() + " " + QueueConsumer.class + " " + queue.toString());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
