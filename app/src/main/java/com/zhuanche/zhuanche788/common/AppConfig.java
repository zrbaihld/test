package com.zhuanche.zhuanche788.common;

import android.content.Context;

/**
 * 项目配置
 * 
 * @author oddoson
 * 
 */
public class AppConfig {
	public static Context applicationContext;
	public static boolean idDebug = false;

	public static Context getApplicationContext() {
		return applicationContext;
	}

	public static void setApplicationContext(Context applicationContext) {
		AppConfig.applicationContext = applicationContext;
	}

}
