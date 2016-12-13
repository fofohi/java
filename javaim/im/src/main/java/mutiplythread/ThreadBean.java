package mutiplythread;

/**
 * Created by alongsea2 on 16/12/1.
 */
public class ThreadBean implements Runnable {

    @Override
    public void run() {
        while (StaticBean.isFlag()){
            synchronized (this){
                System.out.println(this);
                int i = StaticBean.getI();
                System.out.println(Thread.currentThread().getName() + "===> pre " + i);
                i++;
                StaticBean.setI(i);
                System.out.println(Thread.currentThread().getName() + "===> after " + i);
            }

        }
    }
}
