package util;

import io.netty.channel.Channel;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by dell on 2016/7/18.
 */
public class ChannelHashMap {
    private static final ConcurrentHashMap<String,Channel> channelMap = new ConcurrentHashMap<String,Channel>();

    public static ConcurrentHashMap<String,Channel> getMap(){
        return channelMap;
    }

    public static void main(String[] args) {
        byte[] s = "发达省份是范德萨fjsdk".getBytes();
        byte[] s2;
        for (byte b : s) {
            int a = b >> 2;
        }

    }
}
