package com.bj1901.proxy.service.impl;

import com.bj1901.net.utlis.HttpClientUtil;
import com.bj1901.proxy.service.ICodeTempTicketService;
import com.bj1901.proxy.service.ITokenService;
import com.bj1901.utils.JsonStringUtil;
/**
 * @Author: adming
 * @Date: 2019/6/13 0013 17:05
 */
public class CodeTempTicketServiceImpl  implements ICodeTempTicketService{

    private ITokenService tokenService = new TokenServiceImpl();

    @Override
    public String getTicket() {
        // 获取token
        String token = tokenService.getToken();

        // 获取二维码的ticket
        String getTicketUrl = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=" + token;
        String paramBody = "{\"expire_seconds\": 7200, \"action_name\": \"QR_SCENE\", \"action_info\": {\"scene\": {\"scene_id\": bj1901}}}\n";
        String resultTicket = HttpClientUtil.httpPost(getTicketUrl, paramBody);

        // 处理获取到的结果
        return JsonStringUtil.getJsonValueBykey(resultTicket, "ticket");
    }

}
