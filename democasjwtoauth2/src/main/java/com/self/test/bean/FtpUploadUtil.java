package com.self.test.bean;

import com.ctrip.framework.apollo.core.utils.PropertiesUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;


public class FtpUploadUtil {
    private final static Logger logger = LoggerFactory.getLogger(FtpUploadUtil.class);

    private final static String FTP_UPLOAD_CERTIFICATE = "http://localhost:8787/img/uploadImgForCertificate";

    private final static String FTP_UPLOAD_TICKET = "http://localhost:8787/img/uploadImgForTicket";

    //票据
    public final static int TICKET = 0;

    //证件
    public final static int CERTIFICATE = 1;

    private static boolean checkIsNullOrFile(Map<String, MultipartFile> fileMap){
        return fileMap == null || fileMap.size() == 0;
    }


    /**
     * @param fileMap
     * @param token  0 ticket 1 certificate
     * @param fileMap
     * @return
     */
    public static void uploadImgToFtpServer(Map<String, MultipartFile> fileMap, String token, Integer imgType){
        try {
            MultipartBody.Builder bodyBuilder = new MultipartBody.Builder().setType(MultipartBody.FORM);
            for (Map.Entry<String, MultipartFile> entry : fileMap.entrySet()) {
                ImgContentTypeEnum extendEnum = ImgContentTypeEnum.getExtendTypeByContentType(entry.getValue().getContentType());
                if(extendEnum == null){
                    logger.warn("{}'s type {} is not allow to upload",entry.getValue().getName(),entry.getValue().getContentType());
                    continue;
                }
                bodyBuilder.addFormDataPart(entry.getKey(),entry.getValue().getName(),
                        new MultipartBody.Builder().addPart(
                        Headers.of("Content-Disposition", "form-data; filename=\" "+ entry.getValue().getName() + entry.getValue().getContentType()),
                        RequestBody.create(MediaType.parse(entry.getValue().getContentType()),entry.getValue().getBytes()
                        )
                ).build());
            }
            String url = imgType == TICKET ? FTP_UPLOAD_TICKET : FTP_UPLOAD_CERTIFICATE;
            OkHttpClient builderClient = new OkHttpClient();
            MultipartBody body = bodyBuilder.build();
            Request request = new Request.Builder()
                    .url(url + "?token=" + token)
                    .post(body)
                    .build();
            Response response = builderClient.newCall(request).execute();
            ObjectMapper obj = new ObjectMapper();
            System.out.println(response.body().string());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
