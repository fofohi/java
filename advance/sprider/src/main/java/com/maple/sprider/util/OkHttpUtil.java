package com.maple.sprider.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.log4j.Logger;

import java.io.IOException;

/**
 * Created by alongsea2 on 16/10/7.
 */
public class OkHttpUtil {
    private static final Logger logger = Logger.getLogger(OkHttpUtil.class);

    private static OkHttpClient instance = getInstance();

    private static class OkHttpUtilInner{
        private static final OkHttpClient okClientInstance = new OkHttpClient();
    }

    private OkHttpUtil(){

    }

    public static OkHttpClient getInstance(){
        return OkHttpUtilInner.okClientInstance;
    }

    public static Response httpGet(String url){
        try {
            return instance.newCall(new Request.Builder().url(url).build()).execute();
        } catch (IOException e) {
            //log
            logger.error("fail get");
            return null;
        }
    }


}
