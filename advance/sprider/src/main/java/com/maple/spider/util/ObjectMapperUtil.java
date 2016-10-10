package com.maple.spider.util;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by alongsea2 on 16/10/10.
 */
public class ObjectMapperUtil {
    private ObjectMapperUtil(){}

    private static class ObjectMapperUtilInner{
        private static ObjectMapper instance = new ObjectMapper();
    }
    public static ObjectMapper getInstance(){
        return ObjectMapperUtilInner.instance;
    }
}
