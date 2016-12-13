package mutiplythread;

/**
 * Created by alongsea2 on 16/12/1.
 */
public class StaticBean {
    private static int i = 0;
    private static boolean flag = true;

    public static int getI() {
        return i;
    }

    public static void setI(int i) {
        StaticBean.i = i;
    }

    public static boolean isFlag() {
        return flag;
    }

    public static void setFlag(boolean flag) {
        StaticBean.flag = flag;
    }
}
