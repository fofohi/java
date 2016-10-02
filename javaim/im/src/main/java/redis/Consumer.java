package redis;

import org.apache.log4j.Logger;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * Created by dell on 2016/9/5.
 */
class Consumer implements Runnable{

    private static final Logger logger = Logger.getLogger(Consumer.class);

    private static final String queue = "testQueue";

    private RedisTemplate redisTemplate;


    public Consumer(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @SuppressWarnings("unchecked")
    public void rightPopFunc(){

        boolean flag = true;
        while (flag){
            try {
                Integer res = (Integer) redisTemplate.boundListOps(queue).rightPop();
                if(res == null){
                    Thread.sleep(100);
                }
            }catch (Exception e){

            }
        }
    }



    @SuppressWarnings("unchecked")
    @Override
    public void run() {
        rightPopFunc();
    }
}