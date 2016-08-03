package com.zhuanche.zhuanche788.base;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.zhuanche.zhuanche788.R;
import com.zhuanche.zhuanche788.dialog.LoadingDialog;
import com.zhuanche.zhuanche788.utils.DialogUtil;
import com.zhuanche.zhuanche788.utils.LogUtil;
import com.zhuanche.zhuanche788.view.TextImageButton;


public abstract class BaseActivity extends FragmentActivity implements
		OnClickListener {

	private String className = getClass().getName();
	public TextImageButton topBarLeft, topBarRight, topBarCenter;
	public TextView toptext;
	public LoadingDialog loadingDialog;

	protected abstract void initTopBar();

	protected abstract void initUi();

	protected abstract void initListener();

	protected abstract void initData();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ActivityManager.getInstance().addAcitivity(this);
		loadingDialog = DialogUtil.getLoading(this);
		initUi();
		init();
		initTopBar();
		initListener();
		initData();
	}

	void init() {

		View top_bar_container = findViewById(R.id.top_bar_container);
		if (top_bar_container != null) {
			topBarLeft = (TextImageButton) findViewById(R.id.top_bar_left);
			topBarRight = (TextImageButton) findViewById(R.id.top_bar_right);
			topBarCenter = (TextImageButton) findViewById(R.id.top_bar_center);
			topBarLeft.setOnClickListener(this);
			topBarRight.setOnClickListener(this);
			topBarCenter.setOnClickListener(this);
		}
	}

	public <T extends View> T findView(int resId) {
		return (T) findViewById(resId);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.top_bar_left:
			topBarLeftClick();
			break;
		case R.id.top_bar_right:
			topBarRightClick();
		default:
			break;
		}
	}

	public void setTopBarLeftBack() {
		topBarLeft.setImage(R.drawable.icon_back);
	}

	public void topBarLeftClick() {
		finish();
	}

	public void topBarRightClick() {

	}

	public void e(String msg) {
		LogUtil.e(msg);
	}

	public void i(String msg) {
		LogUtil.i(msg);
	}

	@Override
	protected void onDestroy() {
		ActivityManager.getInstance().removeAcitivity(this);
		super.onDestroy();
	}

}
