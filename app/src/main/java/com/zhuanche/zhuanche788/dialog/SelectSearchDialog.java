package com.zhuanche.zhuanche788.dialog;


import android.content.Context;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhuanche.zhuanche788.R;

public class SelectSearchDialog extends BaseDialog{

	public TextView date,jiuyuanren,name,cancal;
	public SelectSearchDialog(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		init();
	}
	private void init() {
		View contentView = View.inflate(getContext(), R.layout.dialog_select_search,
				null);
		setContentView(contentView);
		getWindow().setWindowAnimations(R.anim.slide_in_from_bottom);
		getWindow().setGravity(Gravity.CENTER);
		Window dialogWindow = getWindow();
		WindowManager.LayoutParams lp = dialogWindow.getAttributes();
		Display display = getWindow().getWindowManager().getDefaultDisplay();
		lp.width = (int) ((int) display.getWidth()*0.8);
		dialogWindow.setAttributes(lp);
		date = (TextView) findViewById(R.id.date);
		jiuyuanren = (TextView) findViewById(R.id.jiuyuanren);
		name = (TextView) findViewById(R.id.name);
		cancal = (TextView) findViewById(R.id.cancal);
	}
}
