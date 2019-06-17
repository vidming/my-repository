package com.bj1901.domain.msg;

/**
 * @Author: adming
 * @Date: 2019/6/14 0014 11:22
 */
public class MsgContent {

    private String content;

    public MsgContent() {
    }

    public MsgContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "MsgContent{" +
                "content='" + content + '\'' +
                '}';
    }
}
