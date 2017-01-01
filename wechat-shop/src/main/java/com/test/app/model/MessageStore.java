package com.test.app.model;

/**
 * Created by dell on 2016/9/30.
 */
public class MessageStore {
    private String message;

    public MessageStore() {

        setMessage("Hello Struts User");
    }

    public String getMessage() {

        return message;
    }

    public void setMessage(String message) {

        this.message = message;
    }
}
