package mutiplythread;

/**
 * Created by alongsea2 on 16/12/1.
 */
public class WatiBean implements Runnable {

    NotifyBean notifyBean;

    public WatiBean(NotifyBean notifyBean) {
        this.notifyBean = notifyBean;
    }


    @Override
    public void run() {
        synchronized (notifyBean){
            notifyBean.notify();
            System.out.println("notify");
        }
    }
}
