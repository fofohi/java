package com.szh.zookeeper;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by alongsea2 on 2017/3/22.
 */
public class ZooKeeper {

    private ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(1000);

    public static void main(String[] args) {
        new ZooKeeper();
    }

    public ZooKeeper() {
        Thread c = new Thread(new Consumer());
        c.start();
        Thread p = new Thread(new Producer());
        p.start();
    }

    private class Producer implements Runnable {

        @Override
        public void run() {
            while (true) {

                    try {
                        Thread.sleep(10);
                        arrayBlockingQueue.put(System.currentTimeMillis());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("add");


            }

        }
    }

    private class Consumer implements Runnable {

        @Override
        public void run() {
            while (true){
                try {
                    System.out.println("====>" + arrayBlockingQueue.take() + " poll");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
