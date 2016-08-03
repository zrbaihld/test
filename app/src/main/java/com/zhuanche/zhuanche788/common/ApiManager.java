package com.zhuanche.zhuanche788.common;


import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zhuanche.zhuanche788.model.UserModel;
import com.zhuanche.zhuanche788.utils.PreferencesUtils;

public class ApiManager {
    private static UserModel user;
    private static String driverTel;

    public static String getDriverTel() {
        if (driverTel == null) {
            driverTel = PreferencesUtils.getString(
                    AppConfig.getApplicationContext(), "driverTel");
        }
        return driverTel;
    }

    public static void setDriverTel(String driverTel) {
        ApiManager.driverTel = driverTel;
        PreferencesUtils.putString(AppConfig.getApplicationContext(), "driverTel",
                driverTel);
    }

    public static UserModel getUser() {
        if (user == null) {
            String userString = PreferencesUtils.getString(
                    AppConfig.getApplicationContext(), "user");
            user = JSON.parseObject(userString, UserModel.class);
        }
        return user;
    }

    public static void setUser(UserModel user) {
        ApiManager.user = user;
        PreferencesUtils.putString(AppConfig.getApplicationContext(), "user",
                JSON.toJSONString(user));
    }

    public static String login(String phone, String password) {
        JSONObject json = new JSONObject();
        json.put("driverTel", phone);
        json.put("password", password);
        return json.toJSONString();
    }

    public static String queryDriverOrders(
            @Nullable String orderStatus
            ,@Nullable String orderCreateTime
            ,@Nullable String createTimeStart
            ,@Nullable String createTimeEnd
            ,@NonNull String page
            ,@NonNull String pageSize
    ) {
        JSONObject json = new JSONObject();
        json.put("driverTel", getDriverTel());
        json.put("orderStatus", orderStatus);
        json.put("orderCreateTime", orderCreateTime);
        json.put("createTimeStart", createTimeStart);
        json.put("createTimeEnd", createTimeEnd);
        json.put("page", page);
        json.put("pageSize", pageSize);
        return json.toJSONString();
    }

    public static String updateDriverSign(
    ) {
        JSONObject json = new JSONObject();
        json.put("driverTel", getDriverTel());
        return json.toJSONString();
    }

    public static String findAllotOrderByDriver(
    ) {
        JSONObject json = new JSONObject();
        json.put("driverTel", getDriverTel());
        return json.toJSONString();
    }

    public static String updateAllotOrderByDriver( String allotStatus
            , String orderId
            , String price
            , String endPoint
            , String orderRemark

    ) {
        JSONObject json = new JSONObject();
        json.put("driverTel", getDriverTel());
        json.put("allotStatus", allotStatus);
        json.put("orderId", orderId);
        json.put("price", price);
        json.put("endPoint", endPoint);
        json.put("orderRemark", orderRemark);
        json.put("appToken", user.getAppToken());
        return json.toJSONString();
    }
    public static String updateDriverPosition(String longitude
            , String latitude
    ) {
        JSONObject json = new JSONObject();
        json.put("driverTel",getDriverTel());
        json.put("longitude", longitude);
        json.put("latitude", latitude);
        return json.toJSONString();
    }
//    public static String updateDriverPosition(String phone
//            , String orderStatus
//            , String orderCreateTime
//            , String createTimeStart
//            , String createTimeEnd
//            , String page
//            , String pageSize
//    ) {
//        JSONObject json = new JSONObject();
//        json.put("driverTel",getDriverTel());
//        json.put("orderStatus", orderStatus);
//        json.put("orderCreateTime", orderCreateTime);
//        json.put("createTimeStart", createTimeStart);
//        json.put("createTimeEnd", createTimeEnd);
//        json.put("page", page);
//        json.put("pageSize", pageSize);
//        return json.toJSONString();
//    }


}
