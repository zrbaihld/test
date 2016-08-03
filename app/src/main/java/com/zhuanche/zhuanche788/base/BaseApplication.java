package com.zhuanche.zhuanche788.base;

import android.app.Application;

import com.zhuanche.zhuanche788.common.AppConfig;
import com.zhuanche.zhuanche788.common.DirManager;


public class BaseApplication extends Application {


	@Override
	public void onCreate() {
		super.onCreate();
		initApp();
//	SDKInitializer.initialize(this);
	}
 

	void initApp() {
		AppConfig.applicationContext = this;
		DirManager.createAppDirs();
	}


}
