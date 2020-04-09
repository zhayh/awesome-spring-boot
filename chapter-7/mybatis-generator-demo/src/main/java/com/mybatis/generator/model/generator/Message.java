package com.mybatis.generator.model.generator;

import lombok.Data;

import java.io.Serializable;

/**
 * message
 * @author 
 */

public class Message implements Serializable {
    private Integer msgId;

    private String msgText;

    private String msgSummary;

    private static final long serialVersionUID = 1L;

    public Integer getMsgId() {
        return msgId;
    }

    public void setMsgId(Integer msgId) {
        this.msgId = msgId;
    }

    public String getMsgText() {
        return msgText;
    }

    public void setMsgText(String msgText) {
        this.msgText = msgText;
    }

    public String getMsgSummary() {
        return msgSummary;
    }

    public void setMsgSummary(String msgSummary) {
        this.msgSummary = msgSummary;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Message other = (Message) that;
        return (this.getMsgId() == null ? other.getMsgId() == null : this.getMsgId().equals(other.getMsgId()))
            && (this.getMsgText() == null ? other.getMsgText() == null : this.getMsgText().equals(other.getMsgText()))
            && (this.getMsgSummary() == null ? other.getMsgSummary() == null : this.getMsgSummary().equals(other.getMsgSummary()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getMsgId() == null) ? 0 : getMsgId().hashCode());
        result = prime * result + ((getMsgText() == null) ? 0 : getMsgText().hashCode());
        result = prime * result + ((getMsgSummary() == null) ? 0 : getMsgSummary().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", msgId=").append(msgId);
        sb.append(", msgText=").append(msgText);
        sb.append(", msgSummary=").append(msgSummary);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
