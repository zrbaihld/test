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


public class PinglunDialog extends BaseDialog {
	public EditText contant;
	public ImageView iv01, iv02, iv03;
	public Button mButton;

	public PinglunDialog(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		init();
	}

	private void init() {
		View contentView = View.inflate(getContext(), R.layout.dialog_pinglun,
				null);
		setContentView(contentView);
		getWindow().setWindowAnimations(R.anim.slide_in_from_bottom);
		getWindow().setGravity(Gravity.CENTER);
		Window dialogWindow = getWindow();
		WindowManager.LayoutParams lp = dialogWindow.getAttributes();
		Display display = getWindow().getWindowManager().getDefaultDisplay();
		lp.width = (int) display.getWidth();
		dialogWindow.setAttributes(lp);
		contant = (EditText) findViewById(R.id.edit);
		iv01 = (ImageView) findViewById(R.id.image1);
		iv02 = (ImageView) findViewById(R.id.image2);
		iv03 = (ImageView) findViewById(R.id.image3);
		mButton = (Button) findViewById(R.id.login_login);
	}

}
