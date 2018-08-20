package com.gtjh.classify.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.gtjh.classify.R;
import com.gtjh.classify.bean.CategoryMapBean;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by android on 2018/7/20.
 */

public class CategoryAdapter extends TagAdapter<CategoryMapBean> {
    private onInfoClickListener onInfoClickListener;
    private Context context;

    public CategoryAdapter(List<CategoryMapBean> datas, Context context) {
        super(datas);
        this.context=context;
    }

    @Override
    public View getView(FlowLayout parent, int position, CategoryMapBean itemsBean) {
        TextView tv = (TextView) LayoutInflater.from(context).inflate(R.layout.item_filtrate,
                parent, false);
        tv.setText(itemsBean.getName());
        return null;
    }

    @Override
    public void onSelected(int position, View view) {
        super.onSelected(position, view);
        if (onInfoClickListener!=null){
            onInfoClickListener.onFInfo(position,true);
        }
    }

    @Override
    public void unSelected(int position, View view) {
        super.unSelected(position, view);
        if (onInfoClickListener!=null){
            onInfoClickListener.onFInfo(position,false);
        }
    }

    public void setOnInfoClickListener(onInfoClickListener onInfoClickListener) {
        this.onInfoClickListener = onInfoClickListener;
    }

    public interface onInfoClickListener{
        void onFInfo(int pos,Boolean isCheck);
    }
}
