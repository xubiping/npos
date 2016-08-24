package com.online.goods.api;


import com.online.goods.http.HttpUtils;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2016/8/18.
 */

public class ApiRequest {

    HttpUtils httpUtils = new HttpUtils();
    OutPut output = new OutPut();

    private void ApiRequest(){
        if(ApiConfig.ACCESS_TOKEN.isEmpty()){
            ApiInit();
        }
    }

    public String ApiInit(){
        try {
            HashMap<String, Object> params = ApiConfig.getParam();
            params.put("com_token",ApiConfig.COM_TOKEN);
            params.put("service", PosApi.POS_INIT);
            ExecutorService exs = Executors.newCachedThreadPool();
            String res = httpUtils.post(params);
            return res;
        }catch (Exception e){
            return null;
        }
    }

    public void CheckToken(){
        if(ApiConfig.ACCESS_TOKEN.isEmpty()){
            String res = ApiInit();
            OutPut outPut = new OutPut();
            outPut.format(res);
            if(outPut.getCode()>0) {
                JSONObject obj = (JSONObject)outPut.getOutput();
                try {
                    ApiConfig.ACCESS_TOKEN = obj.getString("accessToken");
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    public String login(String username,String password,String device_sn){
        try {
            CheckToken();
            HashMap<String, Object> params = ApiConfig.getParam();
            params.put("service",PosApi.POS_LOGIN);
            params.put("user",username);
            params.put("pwd",password);
            params.put("device_sn", "012345678");


            String res = httpUtils.post(params);
            return res;
        }catch (Exception e){
            return null;
        }
    }

    public String posApiReq(HashMap<String, Object> params){
        try {
            String res = httpUtils.post(params);
            return res;
        }catch (Exception e){
            return null;
        }
    }
}
