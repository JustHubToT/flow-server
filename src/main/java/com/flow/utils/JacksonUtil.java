package com.flow.utils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Collection;

public class JacksonUtil {

    /**
     * 将对象转换成json格式的字符串
     *
     * @param o object
     * @return string
     */
    public static String object2Json(Object o){
        JSONObject json = new JSONObject(o);
        return json.toString();
    }

    /**
     * 将数组对象转换成json格式的字符串
     *
     * @param collection 数组集合
     * @return string
     */
    public static String list2Json(Collection collection){
        JSONArray json = new JSONArray(collection);
        return json.toString();
    }
}
