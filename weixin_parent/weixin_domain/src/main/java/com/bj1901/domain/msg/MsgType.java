package com.bj1901.domain.msg;

/**
 * @Author: adming
 * @Date: 2019/6/14 0014 11:14
 */
public interface MsgType {
    // 文本
    public static final String MSG_TEXT = "text";
    // 图片
    public static final String MSG_IMAGE = "image";
    // 发送语音消息
    public static final String MSG_VOICE = "voice";
    // 发送视频消息
    public static final String MSG_VIDEO = "video";
    // 发送音乐消息
    public static final String MSG_MUSIC = "music";
    // 发送图文消息（点击跳转到外链）
    public static final String MSG_NEWS = "news";
    // 发送图文消息（点击跳转到图文消息页面）
    public static final String MSG_MPNEWS = "mpnews";
    // 发送菜单消息
    public static final String MSG_MSGMENU = "msgmenu";
}
