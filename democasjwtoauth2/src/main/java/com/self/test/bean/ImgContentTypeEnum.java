package com.self.test.bean;

public enum ImgContentTypeEnum {
    IMG_JPG("image/jpeg",".jpg"),
    IMG_PNG("image/png",".png"),



    ;

    private String contentType;

    private String extendType;


    public static ImgContentTypeEnum getExtendTypeByContentType(String contentType){
        for (ImgContentTypeEnum imgContentTypeEnum : values()) {
            if(imgContentTypeEnum.getContentType().equals(contentType)){
                return imgContentTypeEnum;
            }
        }
        return null;
    }


    ImgContentTypeEnum(String contentType, String extendType) {
        this.contentType = contentType;
        this.extendType = extendType;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getExtendType() {
        return extendType;
    }

    public void setExtendType(String extendType) {
        this.extendType = extendType;
    }
}
