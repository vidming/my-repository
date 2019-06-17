package com.bj1901.proxy.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * @Author: adming
 * @Date: 2019/6/13 0013 16:36
 */
public interface IUserService {

    /**
     * 获取所有用户的openid
     * @return
     */
   public abstract List<String> getUserOpenIds();

    /**
     * 获取所有用户的详细信息
     * @return
     */
   public abstract JSONArray getUserInfo();

    /**
     * 获取单个用户的详细信息
     * @return
     */
    public abstract JSONObject getUserOneInfo(String openid);

}
