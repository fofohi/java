package redis;

import org.apache.log4j.Logger;

import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;


/**
 * Created by dell on 2016/9/5.
 */
@Component
public class TestRedis {

    private static final Logger logger = Logger.getLogger(TestRedis.class);

    private static final String queue = "testQueue";



    public static void main(String[] args) throws UnsupportedEncodingException {
        /*RedisTemplate redisTemplate = (RedisTemplate) new ClassPathXmlApplicationContext("applicationContext.xml").getBean("redisTemplate");

        //new Thread(new Producer(redisTemplate)).start();

        new Thread(new Consumer(redisTemplate)).start();

        logger.info("redis " + redisTemplate);*/

        String s = "策士";

        byte[] d = s.getBytes("UTF-8");

        String ss = new String(d,"GB2312");

        byte[] dd = ss.getBytes("GB2312");


        String e = new String(dd, "ISO8859-1");
        System.out.println((int) e.charAt(0));


       /* try {
            String authCode = "12222";
            byte[] s = ("验证码为["+authCode+"]").getBytes("GB2312");


            System.out.println(new String(s,"GB2312"));

            System.out.println();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }*/
    }


}
