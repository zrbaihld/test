package com.zhuanche.zhuanche788.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * �?次�?�加载所有item
 * 
 * @author oddoson
 * 
 */
public class ExpandedListView extends ListView {

	public ExpandedListView(Context context) {
		super(context);
	}

	public ExpandedListView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// TODO Auto-generated method stub
		int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
				MeasureSpec.AT_MOST);

		super.onMeasure(widthMeasureSpec, expandSpec);
	}
}
