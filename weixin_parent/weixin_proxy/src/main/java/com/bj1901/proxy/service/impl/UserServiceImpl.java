package com.bj1901.proxy.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bj1901.net.utlis.HttpClientUtil;
import com.bj1901.proxy.service.ITokenService;
import com.bj1901.proxy.service.IUserService;
import com.bj1901.utils.JsonStringUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: adming
 * @Date: 2019/6/13 0013 16:38
 */
public class UserServiceImpl implements IUserService{

    private ITokenService tokenService = new TokenServiceImpl();
    
    private String token;

    @Override
    public List<String> getUserOpenIds() {

        // 获取token
        token = tokenService.getToken();

        // 定义接口
        String userOpenidUrl = "https://api.weixin.qq.com/cgi-bin/user/get?access_token=" + token;

        // 执行请求
        String resultUserOpenId = HttpClientUtil.httpGet(userOpenidUrl);

        // 处理结果
        String userOpenids = JsonStringUtil.getJsonObjBykey(resultUserOpenId, "data").getString("openid");
        List<String> openidList = JSONArray.parseArray(userOpenids, String.class);
        return openidList;
    }

    @Override
    public JSONArray getUserInfo() {

        // 获取所有用户的opendid
        List<String> userOpenIds = getUserOpenIds();

        String userInfoUrl = "https://api.weixin.qq.com/cgi-bin/user/info/batchget?access_token=" + token;
        
        // 获取请求参数体
        String paramBody = getParamBody(userOpenIds);
        
        // 执行请求
        String resultUserInfo = HttpClientUtil.httpPost(userInfoUrl, paramBody);

        // 处理结果
        return JsonStringUtil.getJsonArrayBykey(resultUserInfo, "user_info_list");
    }

    @Override
    public JSONObject getUserOneInfo(String openid) {
        // 获取token
        token = tokenService.getToken();

        String url = "https://api.weixin.qq.com/cgi-bin/user/info?access_token="+ token +"&openid="+ openid +"&lang=zh_CN";
        String resultInfo = HttpClientUtil.httpGet(url);
        return JSON.parseObject(resultInfo);
    }

    /**
     * 通过用户的opendId获取json格式的参数数据
     * @param openidList ： 所有用户openid集合
     * @return
     */
    private String getParamBody(List<String> openidList) {
        // 定义封装openid的list集合
        List<Map<String, String>> userList = new ArrayList<>();
        for (String openid : openidList) {
            Map<String, String> map = new HashMap<>();
            map.put("openid", openid);
            map.put("lang", "zh_CN");
            userList.add(map);
        }

        // 封装到map结合中
        Map<String, Object> map = new HashMap<>();
        map.put("user_list", userList);
        return JSONObject.toJSONString(map);
    }
}
