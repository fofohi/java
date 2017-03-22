package com.szh.zookeeper;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by alongsea2 on 2017/3/22.
 */
public class ZooKeeper {

    private ConcurrentLinkedQueue arrayBlockingQueue = new ConcurrentLinkedQueue();

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
                if(arrayBlockingQueue.size() < 50){
                    arrayBlockingQueue.add(System.currentTimeMillis());
                    System.out.println("add");
                }else{

                }

            }

        }
    }

    private class Consumer implements Runnable {

        @Override
        public void run() {
            while (true){
                try {
                    System.out.println("====>" + arrayBlockingQueue.poll() + " poll");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
