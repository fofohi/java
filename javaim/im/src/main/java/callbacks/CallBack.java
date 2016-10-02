package callbacks;

/**
 * Created by dell on 2016/8/31.
 */
public interface CallBack extends Runnable{
    void callBack(String s) throws InterruptedException;
    String getS();
}
