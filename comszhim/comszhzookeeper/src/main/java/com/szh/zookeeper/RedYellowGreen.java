package com.szh.zookeeper;

/**
 * Created by alongsea2 on 2017/3/27.
 */
public class RedYellowGreen {

    private Object lock = new Object();

    public static void main(String[] args) {
        new RedYellowGreen().runLight();
    }

    public void runLight(){
        Green green = new Green(lock);
        Yellow yellow = new Yellow(green);
        Red red = new Red(yellow,lock);
        new Thread(red).start();
        new Thread(green).start();
        new Thread(yellow).start();
    }

}


class Red implements Light{

    private final Yellow yellow;
    private final Object lock;

    public Red(Yellow yellow, Object lock) {
        this.yellow = yellow;
        this.lock = lock;
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
            synchronized (yellow){
                yellow.notify();
            }

            synchronized (lock){
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class Yellow implements Light{

    private final Green green;

    Yellow(Green green) {
        this.green = green;
    }


    @Override
    public void startLight() {
        System.out.println(this + " color");
    }

    @Override
    public void run() {
        while (true){
            synchronized (this){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                startLight();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (green){
                    green.notify();
                }
            }
        }
    }
}



class Green implements Light{

    private final Object lock;

    public Green(Object lock) {
        this.lock = lock;
    }

    @Override
    public void startLight() {
        System.out.println(this + " color");
    }

    @Override
    public void run() {
        while (true){
            synchronized (this){
                try {
                    wait();
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
            synchronized (lock){
                lock.notify();
            }

        }

    }
}



interface Light extends Runnable{
    void startLight();
}
