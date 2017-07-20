package com.szh.im.controller;

import com.szh.im.dao.TestOneDao;
import com.szh.im.service.UtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by alongsea2 on 2017/3/14.
 */
@RestController
public class JpaController {



    @RequestMapping(value = "/test")
    public void jpaTest(){




    }

    @RequestMapping(value = "/testdubbo")
    public void dubboTest(){

        for(int i = 0 ; i<10 ; i++){
            new Thread(()->{
                try {
                    InputStream inputStream = null;
                    InputStreamReader inputStreamReader = null;
                    BufferedReader reader = null;
                    StringBuffer resultBuffer = new StringBuffer();
                    String tempLine = null;
                    URL realUrl = new URL("http://localhost:8080/test");
                    HttpURLConnection connection = (HttpURLConnection)realUrl.openConnection();
                    // 设置通用的请求属性
                    connection.setRequestProperty("accept", "*/*");
                    connection.setRequestProperty("connection", "Keep-Alive");
                    connection.setRequestProperty("user-agent",
                            "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
                    // 建立实际的连接
                    connection.connect();
                    try {
                        inputStream = connection.getInputStream();
                        inputStreamReader = new InputStreamReader(inputStream);
                        reader = new BufferedReader(inputStreamReader);

                        while ((tempLine = reader.readLine()) != null) {
                            resultBuffer.append(tempLine);
                        }

                    } finally {

                        if (reader != null) {
                            reader.close();
                        }

                        if (inputStreamReader != null) {
                            inputStreamReader.close();
                        }

                        if (inputStream != null) {
                            inputStream.close();
                        }

                    }


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }


    }


}

