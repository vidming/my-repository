package com.bj1901.web.controller;

import com.bj1901.utils.XmlUtil;
import com.bj1901.utils.SecurityKit;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Map;

@Controller
public class WXInitController {

    String token = "bj1901_hzm";  //令牌

    @RequestMapping(value = "/wxinit", method = RequestMethod.GET)
    @ResponseBody
    public String init(String signature, String timestamp, String nonce, String echostr) {

        //1）将token、timestamp、nonce三个参数进行字典序排序
        String paramArray[] = {token, timestamp, nonce};
        Arrays.sort(paramArray);

        //2）将三个参数字符串拼接成一个字符串进行sha1加密
        String param = "";
        for (String s : paramArray) {
            param += s;
        }
        String sha1 = SecurityKit.sha1(param);

        //3）开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
        if (sha1.equals(signature)) {
            System.out.println("接入成功!!");
            return echostr;
        }

        //4.请原样返回echostr参数内容，则接入生效

        return null;
    }

    @RequestMapping(value = "/wxinit", method = RequestMethod.POST)
    @ResponseBody
    public Object init2(HttpServletRequest request) {
        String msgType = null;
        try {
            ServletInputStream is = request.getInputStream();
            Map<String, Object> map = XmlUtil.pareXml(is);
            for (String key : map.keySet()) {
                System.out.println("name:  " + key + "-----textValue: " + map.get(key));
            }
            // 创建被动回复的消息
            msgType = XmlUtil.createXmlStr(map.get("MsgType").toString(), map);
            return msgType;
        } catch (Exception e) {
            e.printStackTrace();
        }

        /*try {
            ServletInputStream inputStream = request.getInputStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String temp = null;
            while ((temp = reader.readLine()) != null) {
                System.out.println(temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        return null;
    }


}
