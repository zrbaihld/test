package com.zhuanche.zhuanche788.dialog;


import android.content.Context;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.zhuanche.zhuanche788.R;

public class MessageDialog extends BaseDialog {
	public TextView mView1, mView2, mView3, mView4, mView5, mView6, mView7,
			mView8, mView9, mView10, mView11, mView12, mView13, mView14,
			mView15, mView16, mView17;

	public MessageDialog(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		init();
	}

	private void init() {
		View contentView = View.inflate(getContext(),
				R.layout.dialog_message_ll, null);
		setContentView(contentView);
		getWindow().setWindowAnimations(R.anim.slide_in_from_bottom);
		getWindow().setGravity(Gravity.CENTER);
		Window dialogWindow = getWindow();
		WindowManager.LayoutParams lp = dialogWindow.getAttributes();
		Display display = getWindow().getWindowManager().getDefaultDisplay();
		lp.width = (int) display.getWidth();
		dialogWindow.setAttributes(lp);
		mView1 = (TextView) findViewById(R.id.tv_01);
		mView2 = (TextView) findViewById(R.id.tv_02);
		mView3 = (TextView) findViewById(R.id.tv_03);
		mView4 = (TextView) findViewById(R.id.tv_04);
		mView5 = (TextView) findViewById(R.id.tv_05);
		mView6 = (TextView) findViewById(R.id.tv_06);
		mView7 = (TextView) findViewById(R.id.tv_07);
		mView8 = (TextView) findViewById(R.id.tv_08);
		mView9 = (TextView) findViewById(R.id.tv_09);
		mView10 = (TextView) findViewById(R.id.tv_10);
		mView11 = (TextView) findViewById(R.id.tv_11);
		mView12 = (TextView) findViewById(R.id.tv_12);
		mView13 = (TextView) findViewById(R.id.tv_13);
		mView14 = (TextView) findViewById(R.id.tv_14);
		mView15 = (TextView) findViewById(R.id.tv_15);
		mView16 = (TextView) findViewById(R.id.tv_16);
		mView17 = (TextView) findViewById(R.id.tv_17);
	}

}
