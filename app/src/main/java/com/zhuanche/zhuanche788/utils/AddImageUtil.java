package com.zhuanche.zhuanche788.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;



import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.format.DateFormat;

import com.zhuanche.zhuanche788.common.AppConfig;


public class AddImageUtil {
    public static Uri uritempFile;

    public static String savebitmap(Intent data) {
        String name = new DateFormat().format("yyyyMMdd_hhmmss",
                Calendar.getInstance(Locale.CHINA))
                + ".jpg";
        Bundle bundle = data.getExtras();
        Bitmap bitmap = (Bitmap) bundle.get("data");// 获取相机返回的数据，并转换为Bitmap图片格式

        FileOutputStream b = null;
        // ???????????????????????????????为什么不能直接保存在系统相册位置呢？？？？？？？？？？？�?
        File file = new File("/sdcard/myImage/");
        file.mkdirs();// 创建文件�?
        String fileName = "/sdcard/myImage/" + name;

        try {
            b = new FileOutputStream(fileName);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, b);// 把数据写入文�?
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                b.flush();
                b.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return fileName;
    }

    /**
     * 保存裁剪之后的图片数�?
     * 
     * @param picdata
     */
    @SuppressLint("SdCardPath")
    public static String getImageToView(Intent data) {
        Bundle extras = data.getExtras();
        String path = null;
        if (extras != null) {
            Bitmap photo = extras.getParcelable("data");
            String name = new DateFormat().format("yyyyMMdd_hhmmss",
                    Calendar.getInstance(Locale.CHINA))
                    + ".jpg";
            FileOutputStream b = null;
            // ???????????????????????????????为什么不能直接保存在系统相册位置呢？？？？？？？？？？？�?
            File file = new File("/sdcard/myImage/");
            file.mkdirs();// 创建文件�?

            try {
                path = "/sdcard/myImage/" + name;
                b = new FileOutputStream(path);

                photo.compress(Bitmap.CompressFormat.JPEG, 100, b);// 把数据写入文�?
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } finally {
                try {
                    b.flush();
                    b.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return path;
    }

    /**
     * 保存裁剪之后的图片数�?
     * 
     * @param picdata
     */
    @SuppressLint("SdCardPath")
    public static String getImageToView(Bitmap data) {
        String path = null;
        Bitmap photo = data;
        String name = new DateFormat().format("yyyyMMdd_hhmmss",
                Calendar.getInstance(Locale.CHINA))
                + ".jpg";
        FileOutputStream b = null;
        // ???????????????????????????????为什么不能直接保存在系统相册位置呢？？？？？？？？？？？�?
        File file = new File("/sdcard/myImage/");
        file.mkdirs();// 创建文件�?

        try {
            path = "/sdcard/myImage/" + name;
            b = new FileOutputStream(path);

            photo.compress(Bitmap.CompressFormat.JPEG, 100, b);// 把数据写入文�?
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                b.flush();
                b.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return path;
    }

    /**
     * 裁剪图片方法实现
     * 
     * @param uri
     */
    public static Intent startPhotoZoom(Uri uri, int num) {

        Intent intent = new Intent("com.android.camera.action.CROP");
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
            String url = FileUtils.getPath(AppConfig.getApplicationContext(),
                    uri);
            intent.setDataAndType(Uri.fromFile(new File(url)), "image/*");
        } else {
            intent.setDataAndType(uri, "image/*");
        }

        // 设置裁剪
        intent.putExtra("crop", "true");
        // aspectX aspectY 是宽高的比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // outputX outputY 是裁剪图片宽高
        intent.putExtra("outputX", 320);
        intent.putExtra("outputY", 320);
        // outputX outputY 黑边
        intent.putExtra("scale", true);
        intent.putExtra("scaleUpIfNeeded", true);
        intent.putExtra("return-data", false);
        intent.putExtra("noFaceDetection", true);
        uritempFile = Uri.parse("file://" + "/"
                + Environment.getExternalStorageDirectory().getPath() + "/"
                + "small.jpg");
        intent.putExtra(MediaStore.EXTRA_OUTPUT, uritempFile);
        intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
        return intent;
    }


    public static Uri geturitempFile() {
        return uritempFile;
    }
}
