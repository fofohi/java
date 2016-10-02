package util;

//import com.xlingmao.util.common.LeanCloudUtil;
import pool.ThreadPool;

import java.util.HashMap;

/**
 * Created by alongsea2 on 16/5/2.
 */
public interface CallBackResult extends Runnable {
    void callback(ThreadPool threadPool);

}
class Ok{
    public static void main(String[] args) {
//        LeanCloudUtil.onlyPush("mm","android","a427e995b527eaecae04a773a8178066",new HashMap<String, Object>(){
//            {
//                put("alert","test");////
//            }
//        });
    }
}