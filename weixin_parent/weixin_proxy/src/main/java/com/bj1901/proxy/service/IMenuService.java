package com.bj1901.proxy.service;

/**
 * @Author: adming
 * @Date: 2019/6/15 0015 11:11
 */
public interface IMenuService {

    /**
     *  创建菜单
     * @param paramBody ： 请求参数
     * @return
     */
    public abstract Boolean createMenu(String paramBody);

}
