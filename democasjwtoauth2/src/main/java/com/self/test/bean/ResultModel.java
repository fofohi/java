package com.self.test.bean;


import java.io.Serializable;
import java.util.HashMap;


public class ResultModel<T> implements Serializable{

    private int code;

    private String msg;

    private T data;

    private long timestamp;

    public static final int SUCCESS = 0;

    public static final String SUCCESS_MSG = "操作成功";

    public static final int ERROR = -1;

    public static final String ERROR_MSG = "系统忙";

    public static final int ILLEGAL_PARAM = -2;

    public static final String ILLEGAL_PARAM_MSG = "参数错误";


    public static final int TOKEN_ERROR = 88;
    public static final int SIGN_ERROR = -3;
    public static final String SIGN_ERROR_MSG = "SIGN ERROR";

    public ResultModel() {
        this.code = SUCCESS;
        this.msg = SUCCESS_MSG;
        this.data = (T) new HashMap<String, String>();
        this.timestamp = System.currentTimeMillis();
    }

    public ResultModel(T data) {
        this.code = SUCCESS;
        this.msg = SUCCESS_MSG;
        this.data = data;
        this.timestamp = System.currentTimeMillis();
    }

    public ResultModel(int code, String errorMsg) {
        this.code = code;
        this.msg = errorMsg;
        this.data = (T) new HashMap<String, String>();
        this.timestamp = System.currentTimeMillis();
    }

    public T getData() {
        if (this.data == null) {
            this.data = (T) new HashMap<String, String>();
        }
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static ResultModel error(String errorMsg) {
        return new ResultModel(ERROR, errorMsg);
    }

    public static ResultModel error(Integer code ,String errorMsg) {
        return new ResultModel(code, errorMsg);
    }


    public static ResultModel illegalParam() {
        return new ResultModel(ILLEGAL_PARAM, ILLEGAL_PARAM_MSG);
    }

    public static ResultModel error() {
        return new ResultModel(ERROR, ERROR_MSG);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
