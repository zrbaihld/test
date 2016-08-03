package com.zhuanche.zhuanche788.utils;

import android.content.Context;

import com.zhuanche.zhuanche788.dialog.LoadingDialog;


public class DialogUtil {

	public static LoadingDialog getLoading(Context context) {
		LoadingDialog loadingDialog = new LoadingDialog(context);
		return loadingDialog;
	}

}
