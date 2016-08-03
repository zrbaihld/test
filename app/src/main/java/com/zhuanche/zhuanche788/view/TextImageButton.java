package com.zhuanche.zhuanche788.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhuanche.zhuanche788.R;
import com.zhuanche.zhuanche788.utils.DensityUtil;


/**
 * 文本图像按钮
 * 
 * <pre>
 *     xml用法
 *             com.oddoson.chianc.view.TextImageButton
 *                 android:id="@+id/textImageButton22"
 *                 android:layout_width="wrap_content"
 *                 android:layout_height="wrap_content"
 *                 android:background="#002266"
 *                 android:padding="10dp"
 *                 android:text="右边"
 *                 android:src="@drawable/ic_app"
 *                 tib:padding="0dp"
 *                 tib:position="right"
 *                 tib:textColor="#ff4a00"
 *                 tib:textSize="18sp" >
 *             com.oddoson.chianc.view.TextImageButton
 *             
 *                  代码设置�?
 *         TextImageButton textImageButton1=(TextImageButton) findViewById(R.id.textImageButton1);
 * 		textImageButton1.setCustormPadding(20f);
 * 		textImageButton1.setImageAndText("哈哈�?",R.drawable.ic_app);
 * </pre>
 * 
 */
public class TextImageButton extends LinearLayout {

	public enum ImagePosition {
		LEFT, RIGHT, TOP, BOTTOM
	}

	private ImageView imageView;
	private TextView textView;
	private float padding = 0;
	private String text;
	private ImagePosition imagePosition;
	private int imgsrcId;

	public TextImageButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();

		TypedArray a = context.obtainStyledAttributes(attrs,
				R.styleable.TextImageButton);
		padding = a.getDimension(R.styleable.TextImageButton_padding, 2);
		textView.setTextColor(a.getColor(R.styleable.TextImageButton_textColor,
				0xff666666));
		int textSize = a.getDimensionPixelSize(
				R.styleable.TextImageButton_textSize,
				DensityUtil.spToPx(getContext(), 14));
		textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
		text = a.getString(R.styleable.TextImageButton_android_text);
		textView.setText(text);
		imgsrcId = a.getResourceId(R.styleable.TextImageButton_android_src, -1);

		int position = a.getInt(R.styleable.TextImageButton_position, 1);
		switch (position) {
		case 1:
			imagePosition = ImagePosition.LEFT;
			break;
		case 2:
			imagePosition = ImagePosition.RIGHT;
			break;
		case 3:
			imagePosition = ImagePosition.TOP;
			break;
		case 4:
			imagePosition = ImagePosition.BOTTOM;
			break;
		default:
			imagePosition = ImagePosition.LEFT;
			break;
		}

		a.recycle();
		setImageAndText(text, imgsrcId, imagePosition);
	}

	private void init() {
		setGravity(Gravity.CENTER);
		setFocusable(true);
		setClickable(true);
		textView = new TextView(getContext());
		imageView = new ImageView(getContext());
		textView.setGravity(Gravity.CENTER);
	}

	/**
	 * 设置布局方向
	 * 
	 * @param position
	 */
	public void setOrientation(ImagePosition position) {
		if (position == ImagePosition.LEFT || position == ImagePosition.RIGHT) {
			setOrientation(LinearLayout.HORIZONTAL);
		} else if (position == ImagePosition.TOP
				|| position == ImagePosition.BOTTOM) {
			setOrientation(LinearLayout.VERTICAL);
		}
	}

	/**
	 * 设置图片和文本间�?
	 * 
	 * @param padding
	 */
	public void setCustormPadding(float padding) {
		this.padding = padding;
	}

	public void setText(String text) {
		setImageAndText(text);
	}

	public void setText(int textResId) {
		setImageAndText(getContext().getString(textResId), -1, null);
	}

	public void setImageAndText(String text) {
		setImageAndText(text, -1, null);
	}

	public void setImage(int imageResId) {
		setImageAndText(null, imageResId, null);
	}

	public void setImageAndText(int imageResId) {
		setImageAndText(null, imageResId, null);
	}

	public void setImageAndText(String text, int imageResId) {
		setImageAndText(text, imageResId, null);
	}

	public void setImageAndText(int resId, int imageResId) {
		setImageAndText(getContext().getString(resId), imageResId, null);
	}

	public void setImageAndText(String text, int imageResId,
			ImagePosition position) {
		removeAllViews();
		if (position != null) {
			imagePosition = position;
		}
		setOrientation(imagePosition);
		imgsrcId = imgsrcId == -1 ? imageResId : imgsrcId;
		if (imgsrcId != -1) {
			imageView.setVisibility(VISIBLE);
			imageView.setImageResource(imageResId);
		} else {
			imageView.setVisibility(GONE);
		}

		this.text = TextUtils.isEmpty(text) ? this.text : text;
		if (TextUtils.isEmpty(this.text)) {
			textView.setVisibility(GONE);
		} else {
			textView.setVisibility(VISIBLE);
			textView.setText(this.text);
		}

		LayoutParams params = new LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

		if (imagePosition == ImagePosition.LEFT) {
			params.setMargins(0, 0, (int) padding, 0);
			addView(imageView, params);
			addView(textView);
		} else if (imagePosition == ImagePosition.RIGHT) {
			params.setMargins((int) padding, 0, 0, 0);
			addView(textView);
			addView(imageView, params);
		} else if (imagePosition == ImagePosition.TOP) {
			params.setMargins(0, 0, 0, (int) padding);
			addView(imageView, params);
			addView(textView);
		} else if (imagePosition == ImagePosition.BOTTOM) {
			params.setMargins(0, (int) padding, 0, 0);
			addView(textView);
			addView(imageView, params);
		}

		if (TextUtils.isEmpty(text) && imgsrcId == -1) {
			setEnabled(false);
		} else {
			setEnabled(true);
		}
	}

	public ImageView getImageView() {
		return imageView;
	}

	public TextView getTextView() {
		return textView;
	}

	public void updateText(String text) {
		this.text = text;
		this.textView.setText(text);
	}

}
