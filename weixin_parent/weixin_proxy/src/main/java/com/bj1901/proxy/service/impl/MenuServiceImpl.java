package com.bj1901.proxy.service.impl;

import com.bj1901.net.utlis.HttpClientUtil;
import com.bj1901.proxy.service.IMenuService;
import com.bj1901.proxy.service.ITokenService;
import com.bj1901.utils.JsonStringUtil;

/**
 * @Author: adming
 * @Date: 2019/6/15 0015 11:12
 */
public class MenuServiceImpl implements IMenuService {

    private ITokenService tokenService = new TokenServiceImpl();

    @Override
    public Boolean createMenu(String paramBody) {

        // 定义接口地址
        String menuUrl = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=" + tokenService.getToken();

        // 执行请求
        String resultInfo = HttpClientUtil.httpPost(menuUrl, paramBody);

        // 处理结果
        if ("ok".equalsIgnoreCase(JsonStringUtil.getJsonValueBykey(resultInfo, "errmsg"))) {
            return true;
        }
        return false;
    }
}
