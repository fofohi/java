package redis;

import org.apache.log4j.Logger;
import org.springframework.data.redis.core.RedisTemplate;

class Producer implements Runnable{

    private static final Logger logger = Logger.getLogger(Producer.class);

    private static final String queue = "testQueue";

    private RedisTemplate redisTemplate;

    public Producer(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void run() {
        int i = 0;
        while (true){

            logger.info("==== push list " + i);
            redisTemplate.boundListOps(queue).leftPush(i);
            i++;
        }

    }
}