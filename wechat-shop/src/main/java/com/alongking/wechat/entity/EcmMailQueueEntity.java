package com.alongking.wechat.entity;

import javax.persistence.*;

/**
 * Created by alongsea2 on 2017/1/8.
 */
@Entity
@Table(name = "ecm_mail_queue", schema = "fenshang", catalog = "")
public class EcmMailQueueEntity {
    private int queueId;
    private String mailTo;
    private String mailEncoding;
    private String mailSubject;
    private String mailBody;
    private byte priority;
    private byte errNum;
    private int addTime;
    private int lockExpiry;

    @Id
    @Column(name = "queue_id", nullable = false)
    public int getQueueId() {
        return queueId;
    }

    public void setQueueId(int queueId) {
        this.queueId = queueId;
    }

    @Basic
    @Column(name = "mail_to", nullable = false, length = 150)
    public String getMailTo() {
        return mailTo;
    }

    public void setMailTo(String mailTo) {
        this.mailTo = mailTo;
    }

    @Basic
    @Column(name = "mail_encoding", nullable = false, length = 50)
    public String getMailEncoding() {
        return mailEncoding;
    }

    public void setMailEncoding(String mailEncoding) {
        this.mailEncoding = mailEncoding;
    }

    @Basic
    @Column(name = "mail_subject", nullable = false, length = 255)
    public String getMailSubject() {
        return mailSubject;
    }

    public void setMailSubject(String mailSubject) {
        this.mailSubject = mailSubject;
    }

    @Basic
    @Column(name = "mail_body", nullable = false, length = -1)
    public String getMailBody() {
        return mailBody;
    }

    public void setMailBody(String mailBody) {
        this.mailBody = mailBody;
    }

    @Basic
    @Column(name = "priority", nullable = false)
    public byte getPriority() {
        return priority;
    }

    public void setPriority(byte priority) {
        this.priority = priority;
    }

    @Basic
    @Column(name = "err_num", nullable = false)
    public byte getErrNum() {
        return errNum;
    }

    public void setErrNum(byte errNum) {
        this.errNum = errNum;
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
    @Column(name = "lock_expiry", nullable = false)
    public int getLockExpiry() {
        return lockExpiry;
    }

    public void setLockExpiry(int lockExpiry) {
        this.lockExpiry = lockExpiry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EcmMailQueueEntity that = (EcmMailQueueEntity) o;

        if (queueId != that.queueId) return false;
        if (priority != that.priority) return false;
        if (errNum != that.errNum) return false;
        if (addTime != that.addTime) return false;
        if (lockExpiry != that.lockExpiry) return false;
        if (mailTo != null ? !mailTo.equals(that.mailTo) : that.mailTo != null) return false;
        if (mailEncoding != null ? !mailEncoding.equals(that.mailEncoding) : that.mailEncoding != null) return false;
        if (mailSubject != null ? !mailSubject.equals(that.mailSubject) : that.mailSubject != null) return false;
        if (mailBody != null ? !mailBody.equals(that.mailBody) : that.mailBody != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = queueId;
        result = 31 * result + (mailTo != null ? mailTo.hashCode() : 0);
        result = 31 * result + (mailEncoding != null ? mailEncoding.hashCode() : 0);
        result = 31 * result + (mailSubject != null ? mailSubject.hashCode() : 0);
        result = 31 * result + (mailBody != null ? mailBody.hashCode() : 0);
        result = 31 * result + (int) priority;
        result = 31 * result + (int) errNum;
        result = 31 * result + addTime;
        result = 31 * result + lockExpiry;
        return result;
    }
}
