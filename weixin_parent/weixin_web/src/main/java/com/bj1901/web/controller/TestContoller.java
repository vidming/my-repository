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
                "    \"button\": [\n" +
                "        {\n" +
                "            \"name\": \"扫码\", \n" +
                "            \"sub_button\": [\n" +
                "                {\n" +
                "                    \"type\": \"scancode_waitmsg\", \n" +
                "                    \"name\": \"扫码带提示\", \n" +
                "                    \"key\": \"rselfmenu_0_0\", \n" +
                "                    \"sub_button\": [ ]\n" +
                "                }, \n" +
                "                {\n" +
                "                    \"type\": \"scancode_push\", \n" +
                "                    \"name\": \"扫码推事件\", \n" +
                "                    \"key\": \"rselfmenu_0_1\", \n" +
                "                    \"sub_button\": [ ]\n" +
                "                }\n" +
                "            ]\n" +
                "        }, \n" +
                "        {\n" +
                "            \"name\": \"发图\", \n" +
                "            \"sub_button\": [\n" +
                "                {\n" +
                "                    \"type\": \"pic_sysphoto\", \n" +
                "                    \"name\": \"系统拍照发图\", \n" +
                "                    \"key\": \"rselfmenu_1_0\", \n" +
                "                   \"sub_button\": [ ]\n" +
                "                 }, \n" +
                "                {\n" +
                "                    \"type\": \"pic_photo_or_album\", \n" +
                "                    \"name\": \"拍照或者相册发图\", \n" +
                "                    \"key\": \"rselfmenu_1_1\", \n" +
                "                    \"sub_button\": [ ]\n" +
                "                }, \n" +
                "                {\n" +
                "                    \"type\": \"pic_weixin\", \n" +
                "                    \"name\": \"微信相册发图\", \n" +
                "                    \"key\": \"rselfmenu_1_2\", \n" +
                "                    \"sub_button\": [ ]\n" +
                "                }\n" +
                "            ]\n" +
                "        }, \n" +
                "        {\n" +
                "            \"name\": \"发送位置\", \n" +
                "            \"type\": \"location_select\", \n" +
                "            \"key\": \"rselfmenu_2_0\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        Boolean menuSuccessFlag = menuService.createMenu(paramBody);

        return menuSuccessFlag;
    }

}
