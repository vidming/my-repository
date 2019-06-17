package com.bj1901.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @Author: adming
 * @Date: 2019/6/13 0013 14:25
 */
public class JsonStringUtil {

    /**
     * 处理json字符串，获取指定key的值
     * @param jsonStr : json字符串
     * @param key ： 需要获取的value值
     * @return
     */
    public static String getJsonValueBykey(String jsonStr, String key) {
        JSONObject jsonObj = JSONObject.parseObject(jsonStr);
        if (jsonObj.containsKey(key)) {
            return jsonObj.getString(key);
        }
        return null;
    }

    public static JSONObject getJsonObjBykey(String jsonStr, String key) {
        JSONObject jsonObj = JSONObject.parseObject(jsonStr);
        if (jsonObj.containsKey(key)) {
            return jsonObj.getJSONObject(key);
        }
        return null;
    }

    public static JSONArray getJsonArrayBykey(String jsonStr, String key) {
        JSONObject jsonObj = JSONObject.parseObject(jsonStr);
        if (jsonObj.containsKey(key)) {
            return jsonObj.getJSONArray(key);
        }
        return null;
    }

}
