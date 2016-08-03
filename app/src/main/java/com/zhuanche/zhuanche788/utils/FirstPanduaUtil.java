package com.zhuanche.zhuanche788.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class FirstPanduaUtil {

	public static void panduan(Context context, final ImageView imageView,
			String name) {
		SharedPreferences share = context.getSharedPreferences("runconfig",
				context.MODE_PRIVATE);
		boolean isfirst = share.getBoolean(name, true);
		if (isfirst) {// 第一�?
			imageView.setVisibility(View.VISIBLE);
			Editor editor = share.edit();
			editor.putBoolean(name, false);
			editor.commit();
			imageView.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					imageView.setVisibility(View.GONE);
				}
			});
		} else {
			imageView.setVisibility(View.GONE);
		}
	}

}
