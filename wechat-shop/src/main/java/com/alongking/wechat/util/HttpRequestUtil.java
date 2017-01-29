package com.alongking.wechat.util;

import okhttp3.*;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.*;

/**
 * Created by alongsea2 on 2017/1/18.
 */
public class HttpRequestUtil {

    private static final Logger logger = Logger.getLogger(HttpRequestUtil.class);

    private HttpRequestUtil() {

    }

    public static OkHttpClient getInstance() {
        return HttpRequestUtilInner.instance;
    }

    private static class HttpRequestUtilInner {
        private static OkHttpClient instance = new OkHttpClient();
    }

    public static Response httpGet(String url) {
        return httpGet(url, null);
    }

    public static Response httpGet(String url, Map<String, String> params) {
        try {
            return buildRequest(url, params, HttpRequestType.GET);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Response httpPost(String url) {
        return httpPost(url, null);
    }

    public static Response httpPost(String url, Map<String, String> params) {
        try {
            return buildRequest(url, params, HttpRequestType.POST);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Response buildRequest(String url, Map<String, String> map, HttpRequestType requestType) throws IOException {
        String request = requestType.getRequestType();
        Request.Builder requestBuilder = new Request.Builder().url(url);
        Request buildRequest = null;
        if (request.equals("GET")) {
            buildRequest = requestBuilder.addHeader("User-Agent", "Mozilla/5.0 (Linux; U; Android 2.3.6; zh-cn; GT-S5660 Build/GINGERBREAD) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1 MicroMessenger/4.5.255").get().build();
        } else if (request.equals("POST")) {
            if (map == null || map.size() <= 0) {
                buildRequest = requestBuilder.build();
            } else {
                buildRequest = requestBuilder.post(buildRequestBody(map)).build();
            }
        }
        logger.info("=====> url :" + url + " map:" + (map != null ? map.toString() : "nothing"));
        return getInstance().newCall(buildRequest).execute();
    }

    private static FormBody buildRequestBody(Map<String, String> map) {
        FormBody.Builder formBodyBuilder = new FormBody.Builder();
        for (Map.Entry<String, String> stringEntry : map.entrySet()) {
            formBodyBuilder.add(stringEntry.getKey(), stringEntry.getValue());
        }
        return formBodyBuilder.build();
    }

    public enum HttpRequestType {

        POST("POST"), GET("GET");

        private String requestType;


        HttpRequestType(String requestType) {
            this.requestType = requestType;
        }

        public String getRequestType() {
            return requestType;
        }
    }

}
