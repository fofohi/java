package callbacks;

/**
 * Created by alongsea2 on 16/12/14.
 */
public class B {
    //when b happened sth a need to know
    //so b need notify a by invoke a's func
    private A a;

    public B(A a) {
        this.a = a;
    }

    public void callA(){
        a.needKnowSth(" a tell b sth", new CallBack() {
            @Override
            public void callBack(String s) {
                System.out.println(s);
            }
        });
    }

    public static void main(String[] args) {
        A a = new A();

        B b = new B(a);

        b.callA();
    }
}
