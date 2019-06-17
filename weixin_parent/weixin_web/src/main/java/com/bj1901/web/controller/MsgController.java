package com.bj1901.web.controller;

import com.bj1901.proxy.service.IMsgService;
import com.bj1901.proxy.service.impl.MsgServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: adming
 * @Date: 2019/6/14 0014 11:49
 */
@Controller
@RequestMapping("/msg")
public class MsgController {

    private IMsgService msgService = new MsgServiceImpl();

    @RequestMapping("/sendTextMsg")
    @ResponseBody
    public Object sendTextMsg(@RequestParam(name = "openid", required = true) String openid, String msgContent) {
        return msgService.sendTextMsg(openid, msgContent);
    }

}
