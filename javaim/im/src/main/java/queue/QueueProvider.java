package queue;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by dell on 2016/5/18.
 * queue 生产者 持有queue
 */
public class QueueProvider extends Thread{
    private LinkedBlockingQueue<QueueTask> queue;

    QueueProvider(LinkedBlockingQueue<QueueTask> queue){
        this.queue = queue;
    }

    void init(){
        start();
    }
    /**
     * 存放任务
     * @param queueTask
     */
    private void putTask(QueueTask queueTask){
        queue.add(queueTask);
    }

    @Override
    public void run() {
        try {
          // while (true){
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName());
                putTask(new QueueTask());
                System.out.println(queue.size() + " " + QueueProvider.class + " " + queue.toString());
            //}
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
