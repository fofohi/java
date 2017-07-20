package com.szh.im.common;


import org.apache.zookeeper.*;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.jms.listener.AbstractMessageListenerContainer;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.CountDownLatch;

/**
 * Created by alongsea2 on 2017/3/22.
 */
//@Component
public class ZooKeeperMonitor implements ApplicationContextAware {

    private CountDownLatch latch = new CountDownLatch(1);
    private CountDownLatch latc2 = new CountDownLatch(1);
    private boolean isRun = true;

    private ApplicationContext applicationContext;



    @PostConstruct
    public void connectToZookeeper() {
        try {

            ZooKeeper zooKeeper = new ZooKeeper("localhost:2181", 2181, new Watcher() {
                @Override
                public void process(WatchedEvent event) {
                    if (event.getState() == Event.KeeperState.SyncConnected) {
                        latch.countDown();
                    }
                }
            });
            latch.await();
            try {
                zooKeeper.create("/test", "master".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            } catch (Exception e) {
                e.printStackTrace();
            }
            test(zooKeeper);
            latc2.await();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void test(ZooKeeper zooKeeper) throws Exception {
        AbstractMessageListenerContainer o = (AbstractMessageListenerContainer) applicationContext.getBean("one");
        AbstractMessageListenerContainer t = (AbstractMessageListenerContainer) applicationContext.getBean("two");

        try {
            //创建child
            String c2 = zooKeeper.create("/test/queue", "1".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
            if (c2 != null) {
                o.start();
                t.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        zooKeeper.exists("/test/queue", new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                if (event.getType().getIntValue() == 2) {
                    isRun = false;
                    try {
                        o.stop();
                        t.stop();

                        zooKeeper.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    try {
                        Thread.sleep(10000);
                        CountDownLatch latch2 = new CountDownLatch(1);
                        ZooKeeper zooKeeper2 = new ZooKeeper("localhost:2181", 2181, new Watcher() {
                            @Override
                            public void process(WatchedEvent event) {
                                if (event.getState() == Event.KeeperState.SyncConnected) {
                                    latch2.countDown();
                                }
                            }
                        });
                        latch2.await();
                        isRun = true;
                        test(zooKeeper2);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
