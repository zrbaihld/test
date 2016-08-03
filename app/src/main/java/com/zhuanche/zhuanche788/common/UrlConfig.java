package com.zhuanche.zhuanche788.common;

/**
 * Url 配置
 */
public class UrlConfig {
    public static String boottom = ".json";
    public static String root = "http://www.abc7880011.com/app/";
    // http://124.160.103.126:8667/api/User/Login'
    public static String login = root + "doLogin" + boottom;
    //	http://www.abc7880011.com/app/queryDriverOrders.json 查询订单
    public static String queryDriverOrders = root + "queryDriverOrders" + boottom;
    //	http://www.abc7880011.com/app/updateDriverPosition.json   2.1.1.3	司机定位坐标存储
    public static String updateDriverPosition = root + "updateDriverPosition" + boottom;
    //	http://www.abc7880011.com/app/updateDriverSign.json   签到
    public static String updateDriverSign = root + "updateDriverSign" + boottom;
    //	http://www.abc7880011.com/app/findAllotOrderByDriver.json  查找分配给自己的订单
    public static String findAllotOrderByDriver = root + "findAllotOrderByDriver" + boottom;
    //	http://www.abc7880011.com/app/updateAllotOrderByDriver.json  //根据司机的响应状态修改分配表里的状态
    public static String updateAllotOrderByDriver = root + "updateAllotOrderByDriver" + boottom;

}
