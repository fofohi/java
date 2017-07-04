package com.szh.zookeeper;


import org.apache.zookeeper.*;

import java.util.concurrent.CountDownLatch;

/**
 * Created by alongsea2 on 2017/3/22.
 */
public class ZooKeeperMonitor {

    private CountDownLatch latch = new CountDownLatch(1);
    private CountDownLatch latc2 = new CountDownLatch(1);
    private boolean isRun = true;

    public static void main(String[] args) {


        new ZooKeeperMonitor().connectToZookeeper();


    }

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
        try {
            //创建child
            String c2 = zooKeeper.create("/test/queue", "1".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
            if (c2 != null) {
                new Thread(() -> {
                    //启动mq线程
                    while (isRun) {
                        System.out.println(Thread.currentThread().getName());
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
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


}
