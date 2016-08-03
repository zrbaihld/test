package com.zhuanche.zhuanche788.view;

import java.util.ArrayList;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Spinner;

import com.zhuanche.zhuanche788.R;
import com.zhuanche.zhuanche788.adapter.ListviewAdapter;
import com.zhuanche.zhuanche788.dialog.SelectDialog;


public class CustomerSpinner extends Spinner implements OnItemClickListener {

	public static SelectDialog dialog = null;
	private ArrayList<String> list;
	public static String text;

	public CustomerSpinner(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	public boolean performClick() {
		Context context = getContext();
		final LayoutInflater inflater = LayoutInflater.from(getContext());
		final View view = inflater.inflate(R.layout.formcustomspinner, null);
		final ListView listview = (ListView) view
				.findViewById(R.id.formcustomspinner_list);
		ListviewAdapter adapters = new ListviewAdapter(context, getList());
		listview.setAdapter(adapters);
		listview.setOnItemClickListener(this);
		dialog = new SelectDialog(context, R.style.dialog);// ����Dialog��������ʽ����
		LayoutParams params = new LayoutParams(650, LayoutParams.FILL_PARENT);
		dialog.setCanceledOnTouchOutside(true);// ���õ��Dialog�ⲿ��������ر�Dialog
		dialog.show();
		dialog.addContentView(view, params);
		return true;
	}

	@Override
	public void onItemClick(AdapterView<?> view, View itemView, int position,
			long id) {
		setSelection(position);
		setText(list.get(position));
		if (dialog != null) {
			dialog.dismiss();
			dialog = null;
		}
	}

	public ArrayList<String> getList() {
		return list;
	}

	public void setList(ArrayList<String> list) {
		this.list = list;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
