package com.alongking.wechat.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * Created by alongsea2 on 2017/1/16.
 *
 */
public class ThreadTest {


    static ExecutorService pool = Executors.newFixedThreadPool(5);














    public static void main(String[] args) {

        for(int i = 0;i< 5 ;i++){
            pool.execute(new ThreadTask(i));
        }
//        pool.shutdown();
//        System.out.println(1);
    }

    static class ThreadTask implements Runnable{

        int i;

        public ThreadTask(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
                System.out.println(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
