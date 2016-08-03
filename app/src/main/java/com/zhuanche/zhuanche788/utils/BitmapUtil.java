package com.zhuanche.zhuanche788.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;

public class BitmapUtil {

	public static Options getImageFileSize(String fileName) {
		Options opts = new Options();
		opts.inJustDecodeBounds = true;// true,只是读图片大小，不申请bitmap内存
		BitmapFactory.decodeFile(fileName, opts);
		return opts;
	}

	public static Bitmap getBitmap(String fileName, int minSideLength,
			int maxNumOfPixels) {
		Options opts = getImageFileSize(fileName);
		opts.inJustDecodeBounds = false;
		opts.inSampleSize = computeSampleSize(opts, minSideLength,
				maxNumOfPixels);
		return BitmapFactory.decodeFile(fileName, opts);
	}

	/**
	 * BitmapFactory.Options opts.inSampleSize 设置缩放比例
	 * 
	 * @param options
	 * @param minSideLength
	 * @param maxNumOfPixels
	 * @return
	 */
	public static int computeSampleSize(Options options,
			int minSideLength, int maxNumOfPixels) {
		int initialSize = computeInitialSampleSize(options, minSideLength,
				maxNumOfPixels);
		int roundedSize;
		if (initialSize <= 8) {
			roundedSize = 1;
			while (roundedSize < initialSize) {
				roundedSize <<= 1;
			}
		} else {
			roundedSize = (initialSize + 7) / 8 * 8;
		}
		return roundedSize;
	}

	private static int computeInitialSampleSize(Options options,
			int minSideLength, int maxNumOfPixels) {
		double w = options.outWidth;
		double h = options.outHeight;
		int lowerBound = (maxNumOfPixels == -1) ? 1 : (int) Math.ceil(Math
				.sqrt(w * h / maxNumOfPixels));
		int upperBound = (minSideLength == -1) ? 128 : (int) Math.min(
				Math.floor(w / minSideLength), Math.floor(h / minSideLength));

		if (upperBound < lowerBound) {
			// return the larger one when there is no overlapping zone.
			return lowerBound;
		}

		if ((maxNumOfPixels == -1) && (minSideLength == -1)) {
			// 原比�?
			return 1;
		} else if (minSideLength == -1) {
			// 按最大像�?
			return lowerBound;
		} else {
			// 按最小边�?
			return upperBound;
		}
	}

	public static byte[] bitmapToByte(Bitmap bitmap) {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		bitmap.compress(CompressFormat.PNG, 100, bos);
		return bos.toByteArray();
	}
	public static byte[] bitmapToByte(String path) {
		File file = new File(path);
		if (!file.exists()) {
			return null;
		}
		Bitmap bitmap = BitmapFactory.decodeFile(path);
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		bitmap.compress(CompressFormat.PNG, 100, bos);
		return bos.toByteArray();
	}
	public static Bitmap byteToBitmap(byte[] data) {
		return BitmapFactory.decodeByteArray(data, 0, data.length);
	}

	public static InputStream bitmap2InputStream(Bitmap bm) {
		InputStream is = new ByteArrayInputStream(bitmapToByte(bm));
		return is;
	}

	public static boolean saveBitmap(String oldSrc, String desc,int compress,
			int maxNumOfPixels) {
		File mFile = new File(desc);
		if (mFile.isFile() && mFile.exists()) {
			mFile.delete();
		}
		try {
			mFile.createNewFile();
			FileOutputStream out = new FileOutputStream(mFile);
			Bitmap bitmap = getBitmap(oldSrc, -1, maxNumOfPixels);
			bitmap.compress(CompressFormat.JPEG, compress, out);
			out.flush();
			out.close();
			bitmap.recycle();
			bitmap=null;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
