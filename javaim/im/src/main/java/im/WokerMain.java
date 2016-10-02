package im;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.List;
/**
 * Created by xianyu on 2016/4/1.
 */
public class WokerMain implements Runnable{
    private static List<Integer> list = new ArrayList<Integer>();

    @Override
    public void run() {
        Woker woker = new Woker();
        woker.serviceLogic(this);
        System.out.println(Thread.currentThread().getName());
    }

    void call(int j,String msg){
        if(msg.equals("done")){
            list.add(j);
        }
    }

    void threadRun(){
        singlePool.getPool().execute(this);
    }

    public static void main(String[] args) {
        WokerMain wokerMain = new WokerMain();
        for (int i=0;i<16;i++){
            wokerMain.threadRun();
        }
        while (list.size() < 16){

        }

        if(list.size() >= 16){
            System.out.println(Thread.currentThread().getName() + " " + list.size() );
        }
    }
}

class Woker{
    void serviceLogic(WokerMain wokerMain){
        int j =0;
        for(int i = 0;i < 16;i++){
            j++;
        }
        wokerMain.call(j,"done");
    }
}

class singlePool{
    private static ExecutorService pool;
    private singlePool(){

    }

    static ExecutorService getPool(){
        if(pool == null){
            pool = Executors.newFixedThreadPool(10);
        }
        return pool;
    }
}



