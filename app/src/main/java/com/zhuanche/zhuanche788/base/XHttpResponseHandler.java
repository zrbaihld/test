package com.zhuanche.zhuanche788.base;



import com.loopj.android.http.TextHttpResponseHandler;
import com.zhuanche.zhuanche788.dialog.LoadingDialog;
import com.zhuanche.zhuanche788.utils.JsonParsing;
import com.zhuanche.zhuanche788.utils.LogUtil;
import com.zhuanche.zhuanche788.utils.TextUtil;
import com.zhuanche.zhuanche788.view.XToast;

import org.apache.http.Header;

public abstract class XHttpResponseHandler extends TextHttpResponseHandler {
	public LoadingDialog mLoadingDialog;

	@Override
	public void onStart() {
		super.onStart();
		LogUtil.e("http onStart url= " + getRequestURI().toString());
		onshowdialog();
		if (mLoadingDialog != null) {
			mLoadingDialog.show();
		}
	}

	public abstract void onshowdialog();

	@Override
	public void onSuccess(int statusCode, Header[] headers, String responseBody) {
		LogUtil.e("http onSuccess statusCode= " + statusCode);
		LogUtil.e("http onSuccess responseBody= " + responseBody);
		JsonParsing jsonParsing=new JsonParsing(responseBody);
		if (jsonParsing.getState()){
			if (!TextUtil.isEmptyString(jsonParsing.getData())){
				if (responseBody.substring(0, 1).equals("{")) {
					success(jsonParsing.getData());
				} else if (responseBody.substring(0, 1).equals("[")) {
					success(jsonParsing.getData());
				}else {
					XToast.show(jsonParsing.getMsg());
				}
			}else {
				XToast.show(jsonParsing.getMsg());
			}
		}else {
			XToast.show(jsonParsing.getMsg());
		}
		super.onSuccess(statusCode, headers, responseBody);
	}

	public void success(String responseBody) {

	}

	@Override
	public void onFailure(int statusCode, Header[] headers,
			String responseBody, Throwable error) {
		LogUtil.e("http onFailure statusCode= " + statusCode);
		LogUtil.e("http onFailure responseBody= " + responseBody);
		if (statusCode == 401) {
			LogUtil.e("http onFailure= ������");
		}
		super.onFailure(statusCode, headers, responseBody, error);
	}

	// public Boolean isSuccess(BaseModel baseModel) {
	// if (baseModel == null || baseModel.getRetcode() == null) {
	// return false;
	// }
	// return baseModel.getRetcode().equalsIgnoreCase(
	// XhttpStatus.SUCCESS.getName());
	// }
	//
	// public Boolean isSuccess(String status) {
	// return status.equalsIgnoreCase(XhttpStatus.SUCCESS.getName());
	// }
	@Override
	public void onFinish() {
		// TODO Auto-generated method stub
		super.onFinish();
		if (mLoadingDialog != null) {
			mLoadingDialog.dismiss();
		}
	}
}
