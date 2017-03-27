package com.szh.zookeeper;

/**
 * Created by alongsea2 on 2017/3/27.
 */
public class RedYellowGreen {

    private Object lockRed = new Object();

    private Object lockYellow = new Object();

    private Object lockGreen = new Object();


    public static void main(String[] args) {
        new RedYellowGreen().runLight();
    }

    public void runLight(){
        Green green = new Green(lockYellow,lockGreen);
        Yellow yellow = new Yellow(lockRed, lockYellow, lockGreen);
        Red red = new Red(lockYellow,lockRed);
        new Thread(red).start();
        new Thread(green).start();
        new Thread(yellow).start();
    }

}


class Red implements Light{

    private final Object lockYellow;
    private final Object lockRed;

    public Red(Object lockYellow, Object lockRed) {
        this.lockYellow = lockYellow;
        this.lockRed = lockRed;
    }

    @Override
    public void startLight() {
        System.out.println(this + " color");
    }

    @Override
    public void run() {
        while (true){
            startLight();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockYellow){
                lockYellow.notify();
            }

            synchronized (lockRed){
                try {
                    Yellow.flag = true;
                    lockRed.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class Yellow implements Light{

    private final Object lockRed;
    private final Object lockYellow;
    private final Object lockGreen;
    public volatile static boolean flag = true;


    Yellow(Object lockRed, Object lockYellow, Object lockGreen) {
        this.lockRed = lockRed;
        this.lockYellow = lockYellow;
        this.lockGreen = lockGreen;
    }


    @Override
    public void startLight() {
        System.out.println(this + " color");
    }

    @Override
    public void run() {
        while (true){
            synchronized (lockYellow){
                try {
                    lockYellow.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                startLight();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(flag){
                    synchronized (lockGreen){
                        lockGreen.notify();
                    }
                }else{
                    synchronized (lockRed){
                        lockRed.notify();
                    }
                }

            }
        }
    }
}



class Green implements Light{

    private final Object lockYellow;
    private final Object lockGreen;

    public Green(Object lockYellow, Object lockGreen) {
        this.lockYellow = lockYellow;
        this.lockGreen = lockGreen;
    }

    @Override
    public void startLight() {
        System.out.println(this + " color");
    }

    @Override
    public void run() {
        while (true){
            synchronized (lockGreen){
                try {
                    lockGreen.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            startLight();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockYellow){
                lockYellow.notify();
                Yellow.flag = false;
            }

        }

    }
}

interface Light extends Runnable{
    void startLight();
}
