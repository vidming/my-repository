package com.bj1901.proxy.service.impl;

import com.bj1901.net.utlis.HttpClientUtil;
import com.bj1901.proxy.service.ITokenService;
import com.bj1901.utils.JsonStringUtil;
import com.bj1901.utils.RedisUtil;

/**
 * @Author: adming
 * @Date: 2019/6/13 0013 16:38
 */
public class TokenServiceImpl implements ITokenService{

    @Override
    public String getToken() {
        // 微信API接口地址
        String wxTokenUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx532eea98c7f78d7d&secret=65a16831ea861ea8aceddc7052816862";

        // 从redis中获取token
        String weixinToken = null;
        Object token = RedisUtil.get("weixinToken");

        if (token != null) {
            // 存在
            weixinToken = (String) token;
        } else {
            // 不存在就直接执行接口获取token
            String resultToken = HttpClientUtil.httpGet(wxTokenUrl);
            // 处理获取到的字符串获取token值
            weixinToken = JsonStringUtil.getJsonValueBykey(resultToken,"access_token");

            // 存入redis中
            if (weixinToken != null) {
                RedisUtil.save("weixinToken", weixinToken, 7000);
            }
        }
        return weixinToken;
    }
}
