package com.bj1901.domain.msg;

/**
 * @Author: adming
 * @Date: 2019/6/14 0014 11:13
 */
public class BaseMsg {

    private String touser;
    private String msgtype;

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    @Override
    public String toString() {
        return "BaseMsg{" +
                "touser='" + touser + '\'' +
                ", msgtype='" + msgtype + '\'' +
                '}';
    }
}
