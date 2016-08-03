package com.zhuanche.zhuanche788.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.Bitmap.CompressFormat;
import android.os.Environment;
import android.util.Log;
import android.view.View;

public class ScreenShotUtils {

	// 获取指定Activity的截屏，保存到png文件
	private static Bitmap takeScreenShot(Activity activity) {
		// View是你�?要截图的View
		View view = activity.getWindow().getDecorView();
		view.setDrawingCacheEnabled(true);
		view.buildDrawingCache();
		Bitmap b1 = view.getDrawingCache();

		// 获取状�?�栏高度
		Rect frame = new Rect();
		activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
		int statusBarHeight = frame.top;
		Log.i("TAG", "" + statusBarHeight);

		// 获取屏幕长和�?
		int width = activity.getWindowManager().getDefaultDisplay().getWidth();
		int height = activity.getWindowManager().getDefaultDisplay()
				.getHeight();
		// 去掉标题�?
		// Bitmap b = Bitmap.createBitmap(b1, 0, 25, 320, 455);
		Bitmap b = Bitmap.createBitmap(b1, 0, statusBarHeight, width, height
				- statusBarHeight);
		view.destroyDrawingCache();
		return b;
	}

	// 保存到sdcard
	public static File saveImage(Bitmap bmp) {
		File appDir = new File(Environment.getExternalStorageDirectory(),
				"Boohee");
		if (!appDir.exists()) {
			appDir.mkdir();
		}
		String fileName = "erweima" + ".png";
		File file = new File(appDir, fileName);
		try {
			FileOutputStream fos = new FileOutputStream(file);
			bmp.compress(CompressFormat.JPEG, 100, fos);
			fos.flush();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return file;
	}

	// 程序入口
	public static File shoot(Activity a) {
		return ScreenShotUtils.saveImage(ScreenShotUtils.takeScreenShot(a));
	}
}
