package com.bj1901.proxy.service;

/**
 * 获取微信公众号二维码参数的业务处理接口
 * @Author: adming
 * @Date: 2019/6/13 0013 16:57
 */
public interface ICodeTempTicketService {

    /**
     * 获取二维码所需要的ticket的值
     * @return
     */
    public abstract String getTicket();

}
