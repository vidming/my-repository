package com.bj1901.utils;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: adming
 * @Date: 2019/6/15 0015 12:51
 */
public class XmlUtil {

    public static Map<String, Object> pareXml(InputStream is) throws Exception {
        // 读取输入流
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(is);
        // 得到xml根元素
        Element root = document.getRootElement();

        // 得到根元素的所有子节点
        List<Element> elementList = root.elements();

        // 遍历所有子节点
        Map map = new HashMap();
        for (Element e : elementList)
            map.put(e.getName(), e.getText());
        // 释放资源
        is.close();
        return map;
    }

    public static String createXmlStr(String msgType, Map<String, Object> map) {
        String replyMsg = "";
        switch (msgType) {
            case "text":
                replyMsg = "<xml>\n" +
                        "  <ToUserName><![CDATA["+ map.get("FromUserName") +"]]></ToUserName>\n" +
                        "  <FromUserName><![CDATA["+ map.get("ToUserName") +"]]></FromUserName>\n" +
                        "  <CreateTime>"+ System.currentTimeMillis() +"</CreateTime>\n" +
                        "  <MsgType><![CDATA[text]]></MsgType>\n" +
                        "  <Content><![CDATA[你好,是文本消息]]></Content>\n" +
                        "</xml>";
                break;
            case "image":
                replyMsg = "<xml>\n" +
                        "  <ToUserName><![CDATA["+ map.get("FromUserName") +"]]></ToUserName>\n" +
                        "  <FromUserName><![CDATA["+ map.get("ToUserName") +"]]></FromUserName>\n" +
                        "  <CreateTime>"+ System.currentTimeMillis() +"</CreateTime>\n" +
                        "  <MsgType><![CDATA[text]]></MsgType>\n" +
                        "  <Content><![CDATA[你好,是图片消息]]></Content>\n" +
                        "</xml>";
                break;
            case "location":
                replyMsg = "<xml>\n" +
                        "  <ToUserName><![CDATA["+ map.get("FromUserName") +"]]></ToUserName>\n" +
                        "  <FromUserName><![CDATA["+ map.get("ToUserName") +"]]></FromUserName>\n" +
                        "  <CreateTime>"+ System.currentTimeMillis() +"</CreateTime>\n" +
                        "  <MsgType><![CDATA[text]]></MsgType>\n" +
                        "  <Content><![CDATA[你好,是定位消息]]></Content>\n" +
                        "</xml>";
                break;
            case "voice":
                replyMsg = "<xml>\n" +
                        "  <ToUserName><![CDATA["+ map.get("FromUserName") +"]]></ToUserName>\n" +
                        "  <FromUserName><![CDATA["+ map.get("ToUserName") +"]]></FromUserName>\n" +
                        "  <CreateTime>"+ System.currentTimeMillis() +"</CreateTime>\n" +
                        "  <MsgType><![CDATA[text]]></MsgType>\n" +
                        "  <Content><![CDATA[你好,是语言消息]]></Content>\n" +
                        "</xml>";
                break;
            case "video":
                replyMsg = "<xml>\n" +
                        "  <ToUserName><![CDATA["+ map.get("FromUserName") +"]]></ToUserName>\n" +
                        "  <FromUserName><![CDATA["+ map.get("ToUserName") +"]]></FromUserName>\n" +
                        "  <CreateTime>"+ System.currentTimeMillis() +"</CreateTime>\n" +
                        "  <MsgType><![CDATA[text]]></MsgType>\n" +
                        "  <Content><![CDATA[你好,是视频消息]]></Content>\n" +
                        "</xml>";
                break;
            case "music":
                replyMsg = "<xml>\n" +
                        "  <ToUserName><![CDATA["+ map.get("FromUserName") +"]]></ToUserName>\n" +
                        "  <FromUserName><![CDATA["+ map.get("ToUserName") +"]]></FromUserName>\n" +
                        "  <CreateTime>"+ System.currentTimeMillis() +"</CreateTime>\n" +
                        "  <MsgType><![CDATA[text]]></MsgType>\n" +
                        "  <Content><![CDATA[你好,是音乐消息]]></Content>\n" +
                        "</xml>";
                break;
            case "news":
                replyMsg = "<xml>\n" +
                        "  <ToUserName><![CDATA["+ map.get("FromUserName") +"]]></ToUserName>\n" +
                        "  <FromUserName><![CDATA["+ map.get("ToUserName") +"]]></FromUserName>\n" +
                        "  <CreateTime>"+ System.currentTimeMillis() +"</CreateTime>\n" +
                        "  <MsgType><![CDATA[text]]></MsgType>\n" +
                        "  <Content><![CDATA[你好,是图文消息]]></Content>\n" +
                        "</xml>";
                break;
        }
        return replyMsg;
    }



}
