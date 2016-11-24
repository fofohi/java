package com.maple.spider.queue;

import com.maple.spider.entity.dto.YiSpiderTaskDto;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.*;
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

    private void init(){
        YiSpiderTaskDto task = spiderQueue.poll();
        if (task != null) {
            pool.execute(task);
            i++;
        }
    }

    @Override
    public void run() {
        while(flag){
            init();
        }
        System.exit(0);
    }

    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("s");
        treeSet.add("a");
        Collections.sort(treeSet, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });
        Iterator<String> it = treeSet.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

    }
}
