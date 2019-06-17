package com.bj1901.domain.msg;

/**
 * @Author: adming
 * @Date: 2019/6/14 0014 11:21
 */
public class TextMsg extends BaseMsg {

    private MsgContent text;

    public MsgContent getText() {
        return text;
    }

    public void setText(MsgContent text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "TextMsg{" +
                "text=" + text +
                '}';
    }
}
