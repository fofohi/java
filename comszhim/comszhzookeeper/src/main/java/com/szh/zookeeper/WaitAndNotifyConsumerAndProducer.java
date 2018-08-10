package com.szh.zookeeper;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class WaitAndNotifyConsumerAndProducer {

    //双方持有的锁
    //注意是对象锁
    private static final Object lock = new Object();

    private static List<Integer> dataList = new CopyOnWriteArrayList<>();


    private static class Consumer implements Runnable{

        @Override
        public void run() {
            //必须同步
            while (true){
                synchronized (WaitAndNotifyConsumerAndProducer.lock){
                    System.out.println("Consumer has get the notify,so Consumer will do my work");
                    if(WaitAndNotifyConsumerAndProducer.dataList.size() > 0){
                        System.out.println("Consumer get " + dataList.get(0));
                        dataList.remove(0);
                    }else{
                        try {
                            System.out.println("there is nothing in list,so Consumer is waiting for the notify");
                            WaitAndNotifyConsumerAndProducer.lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

        //我需要在这里唤醒他来消费
    }

    private static class Consumer2 implements Runnable{

        @Override
        public void run() {
            //必须同步
            while (true){
                //我需要在这里唤醒他来消费
                synchronized (WaitAndNotifyConsumerAndProducer.lock){
                    System.out.println("Consumer2 has get the notify,so I will do my work");
                    if(WaitAndNotifyConsumerAndProducer.dataList.size() > 0){
                        System.out.println("Consumer2 get " + dataList.get(0));
                        dataList.remove(0);
                    }else{
                        try {
                            System.out.println("there is nothing in list,so Consumer2 is waiting for the notify");
                            WaitAndNotifyConsumerAndProducer.lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

    }


    private static class Producer {

        public void produce(int i){
            System.out.println("add sth into this list");
            WaitAndNotifyConsumerAndProducer.dataList.add(i);
            synchronized (WaitAndNotifyConsumerAndProducer.lock){
                System.out.println("notify the consumers to do sth");
                WaitAndNotifyConsumerAndProducer.lock.notify();
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        new Thread(new Consumer()).start();
        new Thread(new Consumer2()).start();
        Producer p = new Producer();
        for (int i = 0; i < 100; i++) {
            p.produce(i);
        }
    }
}

