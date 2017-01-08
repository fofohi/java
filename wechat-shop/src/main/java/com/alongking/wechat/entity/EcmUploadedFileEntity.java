package com.alongking.wechat.entity;

import javax.persistence.*;

/**
 * Created by alongsea2 on 2017/1/8.
 */
@Entity
@Table(name = "ecm_uploaded_file", schema = "fenshang", catalog = "")
public class EcmUploadedFileEntity {
    private int fileId;
    private int storeId;
    private String fileType;
    private int fileSize;
    private String fileName;
    private String filePath;
    private int addTime;
    private byte belong;
    private int itemId;

    @Id
    @Column(name = "file_id", nullable = false)
    public int getFileId() {
        return fileId;
    }

    public void setFileId(int fileId) {
        this.fileId = fileId;
    }

    @Basic
    @Column(name = "store_id", nullable = false)
    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    @Basic
    @Column(name = "file_type", nullable = false, length = 60)
    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    @Basic
    @Column(name = "file_size", nullable = false)
    public int getFileSize() {
        return fileSize;
    }

    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

    @Basic
    @Column(name = "file_name", nullable = false, length = 255)
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Basic
    @Column(name = "file_path", nullable = false, length = 255)
    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Basic
    @Column(name = "add_time", nullable = false)
    public int getAddTime() {
        return addTime;
    }

    public void setAddTime(int addTime) {
        this.addTime = addTime;
    }

    @Basic
    @Column(name = "belong", nullable = false)
    public byte getBelong() {
        return belong;
    }

    public void setBelong(byte belong) {
        this.belong = belong;
    }

    @Basic
    @Column(name = "item_id", nullable = false)
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EcmUploadedFileEntity that = (EcmUploadedFileEntity) o;

        if (fileId != that.fileId) return false;
        if (storeId != that.storeId) return false;
        if (fileSize != that.fileSize) return false;
        if (addTime != that.addTime) return false;
        if (belong != that.belong) return false;
        if (itemId != that.itemId) return false;
        if (fileType != null ? !fileType.equals(that.fileType) : that.fileType != null) return false;
        if (fileName != null ? !fileName.equals(that.fileName) : that.fileName != null) return false;
        if (filePath != null ? !filePath.equals(that.filePath) : that.filePath != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = fileId;
        result = 31 * result + storeId;
        result = 31 * result + (fileType != null ? fileType.hashCode() : 0);
        result = 31 * result + fileSize;
        result = 31 * result + (fileName != null ? fileName.hashCode() : 0);
        result = 31 * result + (filePath != null ? filePath.hashCode() : 0);
        result = 31 * result + addTime;
        result = 31 * result + (int) belong;
        result = 31 * result + itemId;
        return result;
    }
}
