package com.online.goods.api;

import java.util.HashMap;

/**
 *
 */
public class ApiConfig {
    public static String REQ_URL = "http://req.wbasic.com/request.wbs";
    public static String COM_TOKEN = "1000";
    public static String SHOP_CD = "" ;
    public static String ENV = "demo";
    public static String APP_ID ="pos";
    public static String MEDIA_CD = "SHOP";
    public static String ACCESS_TOKEN = "";

    public static HashMap<String, Object> getParam(){
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("accessToken",ApiConfig.ACCESS_TOKEN);
        params.put("env", ApiConfig.ENV);
        params.put("appid",ApiConfig.APP_ID);
        params.put("media_cd", ApiConfig.MEDIA_CD);
        return params;
    }
}
