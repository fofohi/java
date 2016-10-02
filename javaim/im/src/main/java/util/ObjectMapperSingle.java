package util;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by xianyu on 2016/3/21.
 */
public class ObjectMapperSingle {
    private static ObjectMapper objectMapper = new ObjectMapper();
    private ObjectMapperSingle(){}
    public static ObjectMapper getInstance(){
        return objectMapper;
    }
}
