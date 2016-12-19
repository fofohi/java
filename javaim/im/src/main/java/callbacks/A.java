package callbacks;


/**
 * Created by alongsea2 on 16/12/14.
 */
public class A {
    //a need define a func which when b invoke can know what happen

    public void needKnowSth(String sth,CallBack b){
        b.callBack("A call B" + sth);
    }

}
