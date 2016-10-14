package com.maple.spider.queue;

import com.maple.spider.entity.dto.YiSpiderTaskDto;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by dell on 2016/10/14.
 */
@Component
public class SpiderQueue implements Runnable{
    private static ConcurrentLinkedQueue<YiSpiderTaskDto> spiderQueue = new ConcurrentLinkedQueue<YiSpiderTaskDto>();
    private boolean flag = true;
    private static final Logger logger = Logger.getLogger(SpiderQueue.class);

    SpiderQueue(){
        new Thread(this).start();
    }

    public static void addTask(YiSpiderTaskDto yiSpiderTaskDto){
        spiderQueue.add(yiSpiderTaskDto);
    }

    private void init(){
        while (flag){
            YiSpiderTaskDto task = spiderQueue.poll();
            if(task != null){
                logger.info(spiderQueue.size() + "=========");
                System.out.println(task + "=========");
                logger.info(spiderQueue.size() + "=========");
            }
        }
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        init();
    }
}
