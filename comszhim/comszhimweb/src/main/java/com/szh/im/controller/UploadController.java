package com.szh.im.controller;


import org.jboss.netty.handler.codec.http.HttpResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by dell on 2017/3/13.
 */
@RestController
public class UploadController {

    public static ExecutorService pool = Executors.newFixedThreadPool(20);

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public void uploadFile(@RequestParam(value = "url") String url, @RequestParam(value = "dir") String dir) {
        String book = "/Users/alongsea2/Documents/books/hentai/" + dir;
        File f = new File(book);
        if (!f.exists()) {
            f.mkdir();
            f.setWritable(true);
        }
        Pattern pattern = Pattern.compile(".*\\/(.*).thumb.jpg.*");
        Matcher matcher = pattern.matcher(url);
        String s = null;
        if (matcher.find()) {
            s = matcher.group(1);
        }
        File pic = new File(book + "/" + s + ".jpg");
        if (!pic.exists()) {
            pool.execute(() -> {
                try {
                    InputStream inputStream = null;
                    URL realUrl = new URL(url);
                    HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
                    // 设置通用的请求属性
                    connection.setRequestProperty("accept", "*/*");
                    connection.setRequestProperty("connection", "Keep-Alive");
                    connection.setRequestProperty("user-agent",
                            "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
                    // 建立实际的连接
                    connection.connect();
                    try {
                        inputStream = connection.getInputStream();
                        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(pic));
                        BufferedInputStream bufferInputStream = new BufferedInputStream(inputStream);
                        int n;
                        while ((n = bufferInputStream.read()) != -1) {
                            bufferedOutputStream.write(n);
                        }
                        bufferedOutputStream.flush();
                    } finally {
                        if (inputStream != null) {
                            inputStream.close();
                        }

                    }


                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

        }


    }


    @RequestMapping(value = "/index")
    public ModelAndView index() {
        return new ModelAndView("look");
    }


    @RequestMapping(value = "/csv", method = RequestMethod.GET)
    public void csv(HttpServletResponse response) {

        List<String> list = new ArrayList<>();

        for(int i = 0;i<50000 ;i++){
            list.add(i + "");
        }

        response.setContentType("text/csv;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-Disposition",
                "attachment;filename=test.csv");
        try {
            OutputStream outputStream = response.getOutputStream();
            final byte[] bom = new byte[] { (byte)0xEF, (byte)0xBB, (byte)0xBF };
            for (byte b : bom) {
                outputStream.write(b);
            }

            for (String s : list) {
                outputStream.write((s + ",\n").getBytes());
            }

            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
