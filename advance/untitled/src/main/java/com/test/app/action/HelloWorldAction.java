package com.test.app.action;

import com.opensymphony.xwork2.ActionSupport;
import com.test.app.model.MessageStore;

/**
 * Created by dell on 2016/9/30.
 */
public class HelloWorldAction extends ActionSupport {
    private MessageStore messageStore;
    
    public String test() throws Exception {

        messageStore = new MessageStore() ;
        messageStore.setMessage("test");
        return "ss";
    }

    public MessageStore getMessageStore() {
        return messageStore;
    }

    public void setMessageStore(MessageStore messageStore) {
        this.messageStore = messageStore;
    }
}
