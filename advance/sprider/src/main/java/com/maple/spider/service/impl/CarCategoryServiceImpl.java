package com.maple.spider.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.maple.spider.common.Constant;
import com.maple.spider.service.CarCategoryService;
import com.maple.spider.util.ObjectMapperUtil;
import com.maple.spider.util.OkHttpUtil;
import okhttp3.Response;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by alongsea2 on 16/10/8.
 */
@Service
class CarCategoryServiceImpl implements CarCategoryService {
    private static Logger logger = Logger.getLogger(CarCategoryServiceImpl.class);

    @Override
    public void buildCategoryJson() {
        String fileName = "category.json";
        ClassLoader loader = this.getClass().getClassLoader();
        URL jsonFile = loader.getResource(fileName);
        String s = null;
        if(jsonFile == null){
            Response response = OkHttpUtil.httpGet(Constant.CAR_CATEGORY_API_URL);
            try {
                s = parseCategoryJsonp(response.body().string());
                File file = new File(loader.getResource("").getPath() + fileName);
                FileOutputStream out = new FileOutputStream(file);
                out.write(s.getBytes());
            } catch (IOException e) {
                logger.error("error1");
                System.exit(0);
            }
        }else{
            try {
                FileInputStream in = new FileInputStream(new File(jsonFile.getPath()));
                byte[] n = new byte[in.available()];

                StringBuilder sb = new StringBuilder();
                while ( in.read(n) != -1 ){
                    sb.append(new String(n));
                }
                s = sb.toString();
            } catch (IOException e) {
                logger.error("error2");
                System.exit(0);
            }
        }
        ObjectMapper objectMapper = ObjectMapperUtil.getInstance();
        JsonNode jsonNode = null;
        try {
            jsonNode = objectMapper.readTree(s);
            System.out.println(jsonNode.get("A"));
        } catch (IOException e) {
            logger.error("error3");
            System.exit(0);
        }
    }

    private String parseCategoryJsonp(String jsonp){
        Pattern pattern = Pattern.compile("brand:(.*)");
        Matcher matcher = pattern.matcher(jsonp);
        String r = null;
        if (matcher.find()){
            r = matcher.group(1);
        }
        if(r == null){
            return null;
        }
        r = r.replace(":","\":").replace("{","{\"").replace(",",",\"").replace(",\"{",",{");
        return r.substring(0,r.length() - 2);
    }
}
