package com.bj1901.web.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bj1901.proxy.service.ICodeTempTicketService;
import com.bj1901.proxy.service.IUserService;
import com.bj1901.proxy.service.impl.CodeTempTicketServiceImpl;
import com.bj1901.proxy.service.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;

/**
 * @Author: adming
 * @Date: 2019/6/13 0013 11:41
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private ICodeTempTicketService ticketService = new CodeTempTicketServiceImpl();

    private IUserService userService = new UserServiceImpl();

    @RequestMapping("/createCode")
    @ResponseBody
    public Object createCode() {
        String ticket = ticketService.getTicket();
        return "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=" + ticket;
    }

    @RequestMapping("/getUserList")
    public String getUserList(Model model) {
        String ticket = ticketService.getTicket();
        model.addAttribute("codeUrl","https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=" + ticket);
        JSONArray userInfo = userService.getUserInfo();
        model.addAttribute("userList", userInfo);
        return "index";
    }

    @RequestMapping("/getUserOne")
    @ResponseBody
    public Object getUserOne(@RequestParam(name = "openid", required = true) String openid) {
        JSONObject userOneInfo = userService.getUserOneInfo(openid);
        return userOneInfo;
    }

}
