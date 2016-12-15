package callbacks;

/**
 * Created by alongsea2 on 16/12/14.
 */
public class B implements CallBack{
    //when b happened sth a need to know
    //so b need notify a by invoke a's func
    private A a;

    public B(A a) {
        this.a = a;
    }

    public void callA(){
        a.needKnowSth("b tell you sth",this);
    }


    @Override
    public void callBack(String s) {
        System.out.println(s);
    }

    @Override
    public void run() {

    }


    public static void main(String[] args) {
        A a = new A();

        B b = new B(a);

        b.callA();
    }
}
