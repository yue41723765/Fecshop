package com.gtjh.classify.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.gtjh.classify.R;
import com.gtjh.classify.bean.ClassifyBean;
import com.gtjh.classify.bean.FilterItemsBean;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by android on 2018/7/19.
 */

public class FiltrateItemAdapter extends TagAdapter<FilterItemsBean> {
    private Context mContext;
    private onCheckedClickListener onCheckedClickListener;
    private List<FilterItemsBean> data=new ArrayList<>();
    public FiltrateItemAdapter(List<FilterItemsBean> datas,Context context) {
        super(datas);
        this.mContext=context;
        this.data=datas;
    }

    @Override
    public View getView(FlowLayout parent, int position,FilterItemsBean itemsBean) {
        TextView tv = (TextView) LayoutInflater.from(mContext).inflate(R.layout.item_filtrate,
                parent, false);
        tv.setText(itemsBean.getLabel());

        if (itemsBean.isSelected()){
            Set<Integer> integers=new HashSet<>();
            integers.add(position);
            setSelectedList(integers);
        }

        return tv;
    }
    @Override
    public void onSelected(int position, View view) {
        super.onSelected(position, view);
        if (onCheckedClickListener!=null){
            onCheckedClickListener.onChecked(position,true,view);
        }

    }

    @Override
    public void unSelected(int position, View view) {
        super.unSelected(position, view);
        if (onCheckedClickListener!=null){
            onCheckedClickListener.onChecked(position,false,view);
        }
    }

    public void setOnCheckedClickListener(onCheckedClickListener onCheckedClickListener) {
        this.onCheckedClickListener = onCheckedClickListener;
    }

    public interface onCheckedClickListener{
        void onChecked(int pos,Boolean isCheck,View view);
    }
}
