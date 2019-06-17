package com.bj1901.proxy.service;

/**
 * 获取微信API中token值的业务处理接口
 * @Author: adming
 * @Date: 2019/6/13 0013 16:37
 */
public interface ITokenService {

    /**
     * 获取微信API的Token
     * @return
     */
    public abstract String getToken();

}
