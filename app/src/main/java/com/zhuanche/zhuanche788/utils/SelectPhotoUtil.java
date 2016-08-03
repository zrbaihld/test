package com.zhuanche.zhuanche788.utils;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.ContactsContract.Contacts;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.View.OnClickListener;

import com.zhuanche.zhuanche788.dialog.SelectCamerORPhotoDialog;

public class SelectPhotoUtil {
	private static SelectCamerORPhotoDialog SelectCamermDialog;
	private static final String IMAGE_FILE_LOCATION = "file:///sdcard/temp.jpg";// temp
																				// file
	private static Uri imageUri = Uri.parse(IMAGE_FILE_LOCATION);// The Uri to
																	// store the
																	// big
																	// bitmap

	public static void showdialog(final Activity mFragment) {
		// TODO Auto-generated method stub
		SelectCamermDialog = new SelectCamerORPhotoDialog(mFragment);
		SelectCamermDialog.camer.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				SelectCamermDialog.dismiss();
				tocamer(mFragment);
			}
		});
		SelectCamermDialog.photo.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				SelectCamermDialog.dismiss();
				tophoto(mFragment);
			}
		});
		SelectCamermDialog.cannal.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				SelectCamermDialog.dismiss();
			}
		});
		SelectCamermDialog.show();

	}
	public static void showdialog(final Fragment mFragment) {
		// TODO Auto-generated method stub
		SelectCamermDialog = new SelectCamerORPhotoDialog(mFragment.getActivity());
		SelectCamermDialog.camer.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				SelectCamermDialog.dismiss();
				tocamer(mFragment);
			}
		});
		SelectCamermDialog.photo.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				SelectCamermDialog.dismiss();
				tophoto(mFragment);
			}
		});
		SelectCamermDialog.cannal.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				SelectCamermDialog.dismiss();
			}
		});
		SelectCamermDialog.show();

	}
	@SuppressLint("NewApi")
	private static void tophoto(Activity mFragment) {
		// TODO Auto-generated method stub
		Intent picture;
		if (Build.VERSION.SDK_INT < 19) {
			picture = new Intent(Intent.ACTION_GET_CONTENT);
			picture.setType("image/*");

		} else {
			picture = new Intent(
					Intent.ACTION_PICK,
					MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
		}
		picture.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
		mFragment.startActivityForResult(picture, 101);
	}

	@SuppressLint("NewApi")
	private static void tocamer(Activity mFragment) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);// action is
																	// capture
//		intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
		mFragment.startActivityForResult(intent, 102);
	}
	@SuppressLint("NewApi")
	private static void tophoto(Fragment mFragment) {
		// TODO Auto-generated method stub
		Intent picture;
		if (Build.VERSION.SDK_INT < 19) {
			picture = new Intent(Intent.ACTION_GET_CONTENT);
			picture.setType("image/*");

		} else {
			picture = new Intent(
					Intent.ACTION_PICK,
					MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
		}
		picture.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
		mFragment.startActivityForResult(picture, 101);
	}

	@SuppressLint("NewApi")
	private static void tocamer(Fragment mFragment) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);// action is
//		intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
		mFragment.startActivityForResult(intent, 102);
	}
	public static Uri getimageUri() {
		return imageUri;
	}

}
