package com.bj1901.proxy.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.bj1901.domain.msg.MsgContent;
import com.bj1901.domain.msg.MsgType;
import com.bj1901.domain.msg.TextMsg;
import com.bj1901.net.utlis.HttpClientUtil;
import com.bj1901.proxy.service.IMsgService;
import com.bj1901.proxy.service.ITokenService;
import com.bj1901.utils.JsonStringUtil;

/**
 * @Author: adming
 * @Date: 2019/6/14 0014 11:31
 */
public class MsgServiceImpl implements IMsgService{

    private ITokenService tokenService = new TokenServiceImpl();

    @Override
    public Boolean sendTextMsg(String openid, String msgContent) {
        // 设置请求体
        TextMsg textMsg = new TextMsg();
        textMsg.setTouser(openid);
        textMsg.setMsgtype(MsgType.MSG_TEXT);
        textMsg.setText(new MsgContent(msgContent));

        String msgParamBody = JSONObject.toJSONString(textMsg);

        return  excuteMsgRequest(msgParamBody);
    }

    private Boolean excuteMsgRequest(String msgParamBody) {
        // 获取token
        String token = tokenService.getToken();
        String msgUrl = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=" + token;

        // 执行请求
        String resultMsg = HttpClientUtil.httpPost(msgUrl, msgParamBody);

        // 处理结果
        String errmsg = JsonStringUtil.getJsonValueBykey(resultMsg, "errmsg");
        if ("ok".equalsIgnoreCase(errmsg)) {
            return true;
        }
        return false;
    }
}
