package com.gtjh.classify.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.gtjh.classify.R;
import com.gtjh.classify.bean.FilterInfoListBean;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by android on 2018/7/19.
 */

public class FiltrateInfoAdapter extends TagAdapter<FilterInfoListBean.ItemsBean> {
    private Context context;
    private onFInfoClickListener onInfoClickListener;
    public FiltrateInfoAdapter(List<FilterInfoListBean.ItemsBean> datas, Context context) {
        super(datas);
        this.context=context;
    }

    @Override
    public View getView(FlowLayout parent, int position, FilterInfoListBean.ItemsBean itemsBean) {
        TextView tv = (TextView) LayoutInflater.from(context).inflate(R.layout.item_filtrate,
                parent, false);
        tv.setText(itemsBean.get_id());
        return tv;
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

    public void setOnInfoClickListener(onFInfoClickListener onInfoClickListener) {
        this.onInfoClickListener = onInfoClickListener;
    }

    public interface onFInfoClickListener{
        void onFInfo(int pos,Boolean isCheck);
    }
}
