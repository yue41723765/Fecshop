package com.gtjh.common.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

import com.zhy.autolayout.utils.AutoUtils;


public class ViewHolder {
	private View view;
	private Context context;
	private int position;
	private SparseArray<View> Views;
	private OnClickListener clickListener;
	private SparseArray<View> GroupViews;

	public ViewHolder(Context context, int position, ViewGroup group,
					  int layoutId) {
		super();
		this.context = context;
		this.position = position;
		this.Views = new SparseArray<View>();

		view = LayoutInflater.from(context).inflate(layoutId, group, false);
		view.setTag(this);
		AutoUtils.auto(view);
	}

	public static ViewHolder getViewHolder(Context context, View view,
                                           ViewGroup group, int layoutId, int position) {
		if (view == null) {
			return new ViewHolder(context, position, group, layoutId);
		} else {
			ViewHolder vh = (ViewHolder) view.getTag();
			vh.position = position;
			return vh;
		}
	}

	public  <T extends View> T get(int resId) {
		View view = null;
		view = Views.get(resId);
		if (view == null) {
			view = this.view.findViewById(resId);
			if (clickListener != null) {
				try {
					view.setOnClickListener(clickListener);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			Views.put(resId, view);
		}
		return (T) view;
	}

	public void setOnClickLinstener(OnClickListener listener) {
		this.clickListener = listener;
	}

	public View get(int resId, OnItemClickListener listener) {
		GridView view = null;
		view = (GridView) Views.get(resId);
		if (view == null) {
			view = (GridView) this.view.findViewById(resId);
			Views.put(resId, view);
			view.setOnItemClickListener(listener);
		}
		return view;
	}

	public View getView() {
		return view;
	}

	public int getPosition() {
		return position;
	}
}
