package com.zhuanche.zhuanche788.base;

import android.text.TextUtils;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
import com.zhuanche.zhuanche788.R;
import com.zhuanche.zhuanche788.common.AppConfig;
import com.zhuanche.zhuanche788.utils.LogUtil;
import com.zhuanche.zhuanche788.utils.PreferencesUtils;
import com.zhuanche.zhuanche788.utils.ToolUtil;
import com.zhuanche.zhuanche788.view.XToast;

import org.apache.http.entity.StringEntity;

import java.io.File;


public class XHttpClient {
	public static AsyncHttpClient client;
	static {
		client = new AsyncHttpClient();
	}

	public static void addHeader() {
		client.addHeader("Accept", "application/json");
	}

	public static void get(String url, XHttpResponseHandler handler) {
		get(url, null, handler);
	}

	public static void get(String url, RequestParams params,
			XHttpResponseHandler handler) {
		if (client == null) {
			client = new AsyncHttpClient();
		}
		addHeader();
		if (params != null) {
		}
		client.get(url, params, handler);
	}

	public static void get(String url, RequestParams params,
			boolean isExitToken, XHttpResponseHandler handler) {
		if (client == null) {
			client = new AsyncHttpClient();
		}
		addHeader();
		if (params != null && isExitToken) {
		}
		client.get(url, params, handler);
	}

	public static void post(String url, XHttpResponseHandler handler) {
		post(url, new RequestParams(), handler);
	}

	public static void post(String url, RequestParams params,
			XHttpResponseHandler handler) {
		if (client == null) {
			client = new AsyncHttpClient();
		}
		addHeader();
		if (params != null) {
			LogUtil.e("post RequestParams= " + params);
		}
		client.post(url, params, handler);
	}

	/**
	 * API post 方法
	 * 
	 * @param url
	 * @param jsonData
	 * @param handler
	 */
	public static void apiPost(String url, String jsonData,
			XHttpResponseHandler handler) {
		if (!ToolUtil.isNetworkAvailable(AppConfig.getApplicationContext())) {
			XToast.show(R.string.no_network);
			handler.onFailure("", new Throwable("û������"));
			handler.onFinish();
			return;
		}
		if (client == null) {
			client = new AsyncHttpClient();
		}
		String root_url = PreferencesUtils.getString(
				AppConfig.applicationContext, "ROOTURL");

		if (!TextUtils.isEmpty(root_url)) {
			url=url.replaceAll("124.160.103.126", root_url);
			System.out.println(url);
		}
		addHeader();
		
		try {
			LogUtil.e("post jsondata= " + jsonData);
			handler.setCharset("UTF-8");
			client.post(AppConfig.applicationContext, url, new StringEntity(
					jsonData, "UTF-8"), "application/json", handler);
		} catch (Exception e) {
		}
	}

	public static void apiget(String url, RequestParams jsonData,
			XHttpResponseHandler handler) {
		if (!ToolUtil.isNetworkAvailable(AppConfig.getApplicationContext())) {
			XToast.show(R.string.no_network);
			handler.onFailure("", new Throwable("û������"));
			handler.onFinish();
			return;
		}
		if (client == null) {
			client = new AsyncHttpClient();
		}
		String root_url = PreferencesUtils.getString(
				AppConfig.applicationContext, "ROOTURL");

		if (!TextUtils.isEmpty(root_url)) {
			url=url.replaceAll("124.160.103.126", root_url);
			System.out.println(url);
		}
		addHeader();
		try {
			LogUtil.e("post jsondata= " + jsonData);
			handler.setCharset("UTF-8");
			client.get(url, jsonData, handler);
		} catch (Exception e) {
		}
	}

	public static void apipost(String url, RequestParams params,
			XHttpResponseHandler handler) {
		if (client == null) {
			client = new AsyncHttpClient();
		}
		client.setTimeout(6000);
		if (params != null) {
			LogUtil.e("post RequestParams= " + params);
		}
		String root_url = PreferencesUtils.getString(
				AppConfig.applicationContext, "ROOTURL");

		if (!TextUtils.isEmpty(root_url)) {
			url=url.replaceAll("124.160.103.126", root_url);
		}
		client.post(url, params, handler);
	}

	public static void apipost(String url, String jsonData,
			XHttpResponseHandler handler) {
		if (client == null) {
			client = new AsyncHttpClient();
		}
		client.setTimeout(6000);
		if (jsonData != null) {
			LogUtil.e("post RequestParams= " + jsonData);
		}
		try {
			client.post(AppConfig.applicationContext, url, new StringEntity(
					jsonData, "UTF-8"), "application/json", handler);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * @param path
	 *            Ҫ�ϴ����ļ�·��
	 * @param url
	 *            ����˽���URL
	 * @throws Exception
	 */
	public static void uploadFile(String path, String url,
			XHttpResponseHandler handler) throws Exception {
		File file = new File(path);
		if (file.exists() && file.length() > 0) {
			RequestParams params = new RequestParams();
			params.put("uploadfile", file);
			// �ϴ��ļ�
			System.out.println(path);
			client.post(url, params, handler);
		} else {
			XToast.show("�ļ�������");
		}
	}
}
