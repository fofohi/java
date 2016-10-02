package queue;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by dell on 2016/5/18.
 */
public class RunQueue extends Thread{
    private static LinkedBlockingQueue<QueueTask> queue = new LinkedBlockingQueue<QueueTask>();

    public static void main(String[] args) {
        new QueueProvider(queue).init();
        new QueueConsumer(queue).init();
    }
}
