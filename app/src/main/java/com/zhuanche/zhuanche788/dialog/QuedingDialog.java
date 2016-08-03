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


public class QuedingDialog extends BaseDialog {
	public TextView title, contant;
	public Button cancel, confirm;

	public QuedingDialog(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		init();
	}

	private void init() {
		View contentView = View.inflate(getContext(), R.layout.dialog_queding,
				null);
		setContentView(contentView);
		getWindow().setWindowAnimations(R.anim.slide_in_from_bottom);
		getWindow().setGravity(Gravity.CENTER);
		Window dialogWindow = getWindow();
		WindowManager.LayoutParams lp = dialogWindow.getAttributes();
		Display display = getWindow().getWindowManager().getDefaultDisplay();
		lp.width = (int) ((int) display.getWidth() * 0.8);
		dialogWindow.setAttributes(lp);
		title = (TextView) findViewById(R.id.title);
		contant = (TextView) findViewById(R.id.contant);
		cancel = (Button) findViewById(R.id.cancel);
		confirm = (Button) findViewById(R.id.confirm);
	}
}
