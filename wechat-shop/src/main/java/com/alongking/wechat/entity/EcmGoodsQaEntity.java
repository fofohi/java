package com.alongking.wechat.entity;

import javax.persistence.*;

/**
 * Created by alongsea2 on 2017/1/8.
 */
@Entity
@Table(name = "ecm_goods_qa", schema = "fenshang", catalog = "")
public class EcmGoodsQaEntity {
    private int quesId;
    private String questionContent;
    private int userId;
    private int storeId;
    private String email;
    private int itemId;
    private String itemName;
    private String replyContent;
    private int timePost;
    private int timeReply;
    private byte ifNew;
    private String type;

    @Id
    @Column(name = "ques_id", nullable = false)
    public int getQuesId() {
        return quesId;
    }

    public void setQuesId(int quesId) {
        this.quesId = quesId;
    }

    @Basic
    @Column(name = "question_content", nullable = false, length = 255)
    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    @Basic
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
    @Column(name = "email", nullable = false, length = 60)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "item_id", nullable = false)
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    @Basic
    @Column(name = "item_name", nullable = false, length = 255)
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Basic
    @Column(name = "reply_content", nullable = false, length = 255)
    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    @Basic
    @Column(name = "time_post", nullable = false)
    public int getTimePost() {
        return timePost;
    }

    public void setTimePost(int timePost) {
        this.timePost = timePost;
    }

    @Basic
    @Column(name = "time_reply", nullable = false)
    public int getTimeReply() {
        return timeReply;
    }

    public void setTimeReply(int timeReply) {
        this.timeReply = timeReply;
    }

    @Basic
    @Column(name = "if_new", nullable = false)
    public byte getIfNew() {
        return ifNew;
    }

    public void setIfNew(byte ifNew) {
        this.ifNew = ifNew;
    }

    @Basic
    @Column(name = "type", nullable = false, length = 10)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EcmGoodsQaEntity that = (EcmGoodsQaEntity) o;

        if (quesId != that.quesId) return false;
        if (userId != that.userId) return false;
        if (storeId != that.storeId) return false;
        if (itemId != that.itemId) return false;
        if (timePost != that.timePost) return false;
        if (timeReply != that.timeReply) return false;
        if (ifNew != that.ifNew) return false;
        if (questionContent != null ? !questionContent.equals(that.questionContent) : that.questionContent != null)
            return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (itemName != null ? !itemName.equals(that.itemName) : that.itemName != null) return false;
        if (replyContent != null ? !replyContent.equals(that.replyContent) : that.replyContent != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = quesId;
        result = 31 * result + (questionContent != null ? questionContent.hashCode() : 0);
        result = 31 * result + userId;
        result = 31 * result + storeId;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + itemId;
        result = 31 * result + (itemName != null ? itemName.hashCode() : 0);
        result = 31 * result + (replyContent != null ? replyContent.hashCode() : 0);
        result = 31 * result + timePost;
        result = 31 * result + timeReply;
        result = 31 * result + (int) ifNew;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}
