package com.bj1901.web.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bj1901.proxy.service.ICodeTempTicketService;
import com.bj1901.proxy.service.IMenuService;
import com.bj1901.proxy.service.IUserService;
import com.bj1901.proxy.service.impl.CodeTempTicketServiceImpl;
import com.bj1901.proxy.service.impl.MenuServiceImpl;
import com.bj1901.proxy.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: adming
 * @Date: 2019/6/13 0013 18:33
 */
@Controller
@RequestMapping("/test")
public class TestContoller {

    private ICodeTempTicketService ticketService = new CodeTempTicketServiceImpl();

    private IUserService userService = new UserServiceImpl();

    private IMenuService menuService = new MenuServiceImpl();

    @RequestMapping("/getCodeTemp")
    @ResponseBody
    public Object getCodeTemp() {
        String ticket = ticketService.getTicket();
        return ticket;
    }

    @RequestMapping("/getUserList")
    @ResponseBody
    public Object getUserList() {
        JSONArray userInfo = userService.getUserInfo();
        return userInfo;
    }

    @RequestMapping("/createMenu")
    @ResponseBody
    public Object createMenu() {

        String paramBody = "{\n" +
                "     \"button\":[\n" +
                "     {    \n" +
                "          \"type\":\"click\",\n" +
                "          \"name\":\"石头\",\n" +
                "          \"key\":\"shitou\"\n" +
                "      },\n" +
                "\t  {    \n" +
                "          \"type\":\"click\",\n" +
                "          \"name\":\"剪刀\",\n" +
                "          \"key\":\"jiandao\"\n" +
                "      },\n" +
                "\t  {    \n" +
                "          \"type\":\"click\",\n" +
                "          \"name\":\"布\",\n" +
                "          \"key\":\"bu\"\n" +
                "      }\n" +
                " }";
        Boolean menuSuccessFlag = menuService.createMenu(paramBody);

        return menuSuccessFlag;
    }

}
