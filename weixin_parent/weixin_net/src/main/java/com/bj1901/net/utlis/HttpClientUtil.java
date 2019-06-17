package com.bj1901.net.utlis;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @Author: adming
 * @Date: 2019/6/13 0013 11:09
 */
public class HttpClientUtil {

    private static HttpClient httpClient = HttpClientBuilder.create().build();

    /**
     * get接口获取返回参数
     * @param url： 接口的url地址
     * @return ： 返回请求接口地址的放回的参数
     */
    public static String httpGet(String url) {
        // 设置方法
        HttpGet httpGet = new HttpGet(url);

        try {
            // 执行请求
            HttpResponse response = httpClient.execute(httpGet);
            // 获取结果
            System.out.println(response.getStatusLine());
            HttpEntity entity = response.getEntity();
            return  EntityUtils.toString(entity, "utf-8");
        } catch (IOException e) {
            System.out.println("httpGet请求异常， errorMsg=" + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public static String httpPost(String url, String paramBody) {
        // 设置方法
        HttpPost httpPost = new HttpPost(url);

        try {
            // 设置请求头
            httpPost.setHeader("Contont-Type", "application/json;charset=utf8");
            // 设置请求体
            StringEntity stringEntity = new StringEntity(paramBody, "utf-8");
            httpPost.setEntity(stringEntity);
            // 执行请求
            HttpResponse response = httpClient.execute(httpPost);
            // 获取结果
            System.out.println(response.getStatusLine());
            HttpEntity entity = response.getEntity();
            return  EntityUtils.toString(entity, "utf-8");
        } catch (IOException e) {
            System.out.println("httpPost请求异常， errorMsg=" + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

   /* public static void main(String[] args) {
        //String tokent = HttpClientUtil.httpGet("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx532eea98c7f78d7d&secret=65a16831ea861ea8aceddc7052816862");
        //System.out.println(tokent);
        //System.out.println("--------------------");
        String kicheck = HttpClientUtil.httpPost("https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=22_KJPLhqc1Dklec5qehMVoL224Jjb-dTyJqvSghQ4qkGXeou_Lo8_7egVisd3Ptkx4gPsg1KoQTue2zAKeyoXeb9vL7w5JIrQVG5PapxLlXrI58gM1K72AY2rkt2gV_IWxtCyC4A9k-gwJLUMELFEaAGAWQP", "{\"expire_seconds\": 7000, \"action_name\": \"QR_SCENE\", \"action_info\": {\"scene\": {\"scene_id\": bj1901}}}\n");
        System.out.println(kicheck);
    }*/

}
