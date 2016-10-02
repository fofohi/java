package callbacks;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * http://www.ibm.com/developerworks/cn/java/j-jtp06197.html
 * Created by dell on 2016/9/1.
 */
class CallBackHandler implements CallBack {

    private String s ;
    private AtomicBoolean t = new AtomicBoolean(true);

    CallBackHandler() {
        new Thread(this).start();
    }

    @Override
    public void callBack(String s) throws InterruptedException {
        System.out.println("callBack :" + Thread.currentThread().getName());
        this.s = s;
        t.set(false);
    }

    @Override
    public String getS() {
        while (t.get()){
            //System.out.println( t + "block");
        }
        System.out.println( t + " break ");
        return this.s;
    }

    @Override
    public void run() {
        try {
            callBack("hey");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
