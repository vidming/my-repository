package com.bj1901.proxy.service;

/**
 * @Author: adming
 * @Date: 2019/6/14 0014 11:29
 */
public interface IMsgService {

    public abstract Boolean sendTextMsg(String openid, String msgContent);

}
