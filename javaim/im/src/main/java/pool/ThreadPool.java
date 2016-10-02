package pool;

import util.CallBackResult;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;


/**
 * Created by dell on 2016/4/25.
 */
public class ThreadPool {
    private static Map<Integer,Worker> workSet = new ConcurrentHashMap<Integer, Worker>();
    private static ConcurrentLinkedQueue taskQueue = new ConcurrentLinkedQueue();

    private static ThreadPool getThreadPoolInstance(int t){
        ThreadPoolSingle.t = t;
        return ThreadPoolSingle.instance;
    }

    private static ThreadPool getThreadPoolInstance(){
        return ThreadPoolSingle.instance;
    }

    //完美单例模式
    private static class ThreadPoolSingle{
        private static int t = 5;
        private static final ThreadPool instance = new ThreadPool(t);
    }

    private ThreadPool(int size) {
        if(workSet != null && workSet.size() < size){
            for (int i = 0; i < size; i++) {
                Worker worker = new Worker();
                workSet.put(i,worker);
            }
        }
    }

    @SuppressWarnings("unchecked")
    private synchronized void exec(Runnable task){
        taskQueue.add(task);
        for (Map.Entry<Integer, Worker> integerWorkerEntry : workSet.entrySet()) {
            Worker worker = integerWorkerEntry.getValue();
            if(worker.getIsWorking() == 0){
                worker.start();
            }
        }
    }

    private class Worker extends Thread{
        private int isWorking = 0;

        public int getIsWorking() {
            return isWorking;
        }

        public void setIsWorking(int isWorking) {
            this.isWorking = isWorking;
        }

        public void run(){
            while ( taskQueue.size() > 0 && this.isWorking == 0){
                System.out.println("Worker:====="+workSet.size()+"=====");
                System.out.println("ThreadPool:=====" + Thread.currentThread().getName()+"=====");
                System.out.println("===== workSet : "+workSet.toString());
                CallBackResult r = (CallBackResult) taskQueue.poll();
                System.out.println("===== taskQueue : "+taskQueue.size());
                if(r != null){
                    this.isWorking = 1;
                    r.run();
                }
            }
            this.isWorking = 0;
        }
    }


    public static void main(String[] args) {


        ThreadPool pool = ThreadPool.getThreadPoolInstance(100);


        System.out.println(ThreadPoolSingle.t);
    }

}
