package com.zhuanche.zhuanche788.dialog;


import android.content.Context;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.zhuanche.zhuanche788.R;

public class SelectCamerORPhotoDialog extends BaseDialog {
	public TextView camer, photo, cannal;

	public SelectCamerORPhotoDialog(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		init();
	}

	private void init() {
		View contentView = View.inflate(getContext(),
				R.layout.dialog_select_camer_photo, null);
		setContentView(contentView);
		getWindow().setWindowAnimations(R.anim.slide_in_from_bottom);
		getWindow().setGravity(Gravity.BOTTOM);
		Window dialogWindow = getWindow();
		WindowManager.LayoutParams lp = dialogWindow.getAttributes();
		Display display = getWindow().getWindowManager().getDefaultDisplay();
		lp.width = (int) display.getWidth();
		dialogWindow.setAttributes(lp);

		camer = (TextView) contentView.findViewById(R.id.dialog_camer);
		photo = (TextView) contentView.findViewById(R.id.dialog_phote);
		cannal = (TextView) contentView.findViewById(R.id.dialog_cannal);
	}

	public void setCameronclick(View.OnClickListener l) {
		camer.setOnClickListener(l);
	}

	public void setPhotoonclick(View.OnClickListener l) {
		camer.setOnClickListener(l);
	}

	public void setCannalonclick(View.OnClickListener l) {
		camer.setOnClickListener(l);
	}
}
