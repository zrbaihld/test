package com.zhuanche.zhuanche788.utils;

import android.text.TextUtils;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonParsing {
//    {
//        "result": {
//        "message": "处理成功",
//                "status": "success",
//                "data": {
//            "appToken": "4f0EZn43hC",
//                    "driverObject": {
//                "id": "8868f0e9331c4b32b31aa657617c02d5",
//                        "status": "9",
//                        "creator": "1225853355",
//                        "createTime": "2016-08-02",
//                        "modifier": null,
//                        "modifyTime": null,
//                        "version": 0,
//                        "delFlag": "0",
//                        "tenantId": null,
//                        "loginId": "15566662222",
//                        "nickName": null,
//                        "fullName": "app测试",
//                        "mobile": "15566662222",
//                        "email": null,
//                        "headimgurl": null,
//                        "sex": null,
//                        "province": null,
//                        "city": null,
//                        "country": null,
//                        "birthdate": null,
//                        "password": "e10adc3949ba59abbe56e057f20f883e",
//                        "wechatId": null,
//                        "idcard": null,
//                        "telephone": null,
//                        "degEdu": null,
//                        "interest": null,
//                        "maritalStatus": null,
//                        "address": null,
//                        "area": null
//            }
//        }
//    }
//    }
    String result;

    public JsonParsing(String json) {
        JSONObject jso;
        try {
            jso = new JSONObject(json);
            result = jso.getString("result");
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.e("解析原始数据异常e" + e.getMessage());
        }
    }

    /**
     * 判断服务器返回值的成功或者失败
     *
     * @return 返回成功或者失败    true成功，false失败
     */
    public  boolean getState() {
        JSONObject jso;
        if (TextUtils.isEmpty(result))
            return false;
        try {
            jso = new JSONObject(result);
            String okStauts = jso.getString("status");
            if ("success".equals(okStauts)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.e("解析原始数据异常e" + e.getMessage());
        }
        return false;
    }

    /**
     * 判断服务器返回值的成功或者失败
     *
     * @return 返回成功或者失败    true成功，false失败
     */
    public  boolean getStateIsEmpty() {
        JSONObject jso;
        if (TextUtils.isEmpty(result))
            return false;
        try {
            jso = new JSONObject(result);
            String okStauts = jso.getString("status");
            if (okStauts == null || "".equals(okStauts)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.e("解析原始数据异常e" + e.getMessage());
            return true;
        }
    }

    /**
     * 是否异地登陆
     *
     * @return
     */
    public  boolean isLogin() {
        JSONObject jso;
        if (TextUtils.isEmpty(result))
            return false;
        try {
            jso = new JSONObject(result);
            String okStauts = jso.getString("state");
            if ("90006".equals(okStauts)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.e("解析原始数据异常e" + e.getMessage());
        }
        return false;
    }

    /**
     * 获取message
     *
     * @return 返回错误信息
     */
    public  String getMsg() {
        JSONObject jso;
        String message = "";
        if (TextUtils.isEmpty(result))
            return "";
        try {
            jso = new JSONObject(result);
            message = jso.getString("message");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return message;
    }

    /**
     * 获取data
     *
     * @return 返回错误信息
     */
    public  String getData() {
        JSONObject jso;
        String message = "";
        if (TextUtils.isEmpty(result))
            return "";
        try {
            jso = new JSONObject(result);
            message = jso.getString("data");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return message;
    }

    /**
     * @param Json
     * @param key
     * @return
     */
    public static String getJson(String Json, String key) {
        JSONObject jso;
        String message = "";
        try {
            jso = new JSONObject(Json);
            message = jso.getString(key);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return message;
    }

//	
//	/**
//	 * 获取验证码
//	 * @param json			json数据
//	 * @return				返回验证码的session
//	 */
//	public static String getCode(String json) {
//		JSONObject jso;
//		String vcjsessionid = "";
//		try {
//			jso = new JSONObject(json);
//			JSONObject o = new JSONObject(jso.getString("details"));
//			vcjsessionid = o.getString("vcjsessionid");
//		} catch (JSONException e) {
//			e.printStackTrace();
//		}
//		return vcjsessionid;
//
//	}


}
