package com.maple.spider.queue;

import com.maple.spider.entity.dto.YiSpiderTaskDto;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * Created by dell on 2016/10/14.
 */
@Component
public class SpiderQueue implements Runnable{
    private static ConcurrentLinkedQueue<YiSpiderTaskDto> spiderQueue = new ConcurrentLinkedQueue<>();
    private static ExecutorService pool = Executors.newFixedThreadPool(30);
    public static volatile int i = 0;
    public static boolean flag = true;

    SpiderQueue(){
        new Thread(this).start();
    }

    public static void addTask(YiSpiderTaskDto yiSpiderTaskDto){
        spiderQueue.add(yiSpiderTaskDto);
    }

    public static void addAllTask(List<YiSpiderTaskDto> tasks){
        spiderQueue.addAll(tasks);
    }

    private void init() {
        YiSpiderTaskDto task = spiderQueue.poll();

        if (task != null) {
            pool.execute(task);
            i++;
        }
    }

    public static void main(String[] args) {
        System.out.println(-2 % 12);
    }

    @Override
    public void run() {
        while(flag){
            init();
        }
        System.exit(0);
    }
}
