package com.maple.spider.vnc;


import com.maple.spider.vnc.RFBDemo.RFBDemo;


/**
 * Created by dell on 2016/11/24.
 */
public class VncServer {


    public static void main(String[] args) {
        try {
            new RFBDemo().startServer(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
