package mutiplythread;

/**
 * Created by alongsea2 on 16/12/1.
 */
public class NotifyBean implements Runnable {

    public synchronized void prinsth(){
        try {
            wait();
            System.out.println("after notify run");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        prinsth();
    }
}
