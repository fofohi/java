package callbacks;



/**
 * Created by dell on 2016/8/31.
 */
public class MainHandler {

    private CallBack callBack;

    MainHandler(CallBack callBack) throws InterruptedException {
        this.callBack = callBack;
    }

    public String getMainFunc() throws InterruptedException {
        return callBack.getS();
    }

    public static void main(String[] args) throws InterruptedException {
        MainHandler mainObj = new MainHandler(new CallBackHandler());
        System.out.println(mainObj.getMainFunc());
        System.out.println(111);
    }
}
