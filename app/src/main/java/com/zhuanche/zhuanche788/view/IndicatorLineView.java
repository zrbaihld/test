package com.zhuanche.zhuanche788.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import com.zhuanche.zhuanche788.R;


public class IndicatorLineView extends View {

	private Paint paint = new Paint();
	private Paint baseLinePaint = new Paint();
	private int baseLineHeight = 2;
	private int indicatorLineHeight = 10;
	private int indicatorSize = 3;
	private int index = 0;// 当前索引
	private int indicatorColor = getResources().getColor(R.color.main_blue);
	private int baseLineColor = getResources().getColor(R.color.main_blue);

	private Rect baseRect = new Rect(), indicatorRect = new Rect();

	public IndicatorLineView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		init();
	}

	public IndicatorLineView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	private void init() {
		paint.setColor(indicatorColor);
		baseLinePaint.setColor(baseLineColor);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		setMeasuredDimension(measureWidth(widthMeasureSpec),
				indicatorLineHeight);
	}

	private int measureWidth(int measureSpec) {
		int specMode = MeasureSpec.getMode(measureSpec);
		int specSize = MeasureSpec.getSize(measureSpec);

		int result = 500;
		if (specMode == MeasureSpec.AT_MOST) {
			result = specSize;
		} else if (specMode == MeasureSpec.EXACTLY) {
			result = specSize;
		}
		return result;
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		final int w = getWidth() / indicatorSize;
		baseRect.set(0, indicatorLineHeight - baseLineHeight, getWidth(),
				indicatorLineHeight);
		canvas.drawRect(baseRect, baseLinePaint);
		indicatorRect.set(index * w, 0, (index + 1) * w, indicatorLineHeight);
		canvas.drawRect(indicatorRect, paint);
	}

	public int getBaseLineHeight() {
		return baseLineHeight;
	}

	public void setBaseLineHeight(int baseLineHeight) {
		this.baseLineHeight = baseLineHeight;
	}

	public int getIndicatorLineHeight() {
		return indicatorLineHeight;
	}

	public void setIndicatorLineHeight(int indicatorLineHeight) {
		this.indicatorLineHeight = indicatorLineHeight;
	}

	public int getIndicatorSize() {
		return indicatorSize;
	}

	public void setIndicatorSize(int indicatorSize) {
		this.indicatorSize = indicatorSize;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
		invalidate();
	}

	public int getIndicatorColor() {
		return indicatorColor;
	}

	public void setIndicatorColor(int indicatorColor) {
		this.indicatorColor = indicatorColor;
		paint.setColor(indicatorColor);
	}

	public int getBaseLineColor() {
		return baseLineColor;
	}

	public void setBaseLineColor(int baseLineColor) {
		this.baseLineColor = baseLineColor;
		baseLinePaint.setColor(baseLineColor);
	}

}
