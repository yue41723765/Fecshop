package com.gtjh.common.adapter.recycler;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;

import com.zhy.autolayout.utils.AutoUtils;

/**
 * Created by android on 2018/5/25.
 */

public class ViewHolder extends RecyclerView.ViewHolder {

    private SparseArray<View> Views;
    private View itemView;
    private int vieType;

    public int getVieType() {
        return vieType;
    }

    public ViewHolder(View itemView,int vieType) {
        super(itemView);
        this.vieType=vieType;
        Views = new SparseArray<>();
        this.itemView =itemView ;
        AutoUtils.auto(itemView);
    }
    public <T extends  View>T findViewById(int id) {
        T view = (T) Views.get(id);
        if (view == null) {
            view = itemView.findViewById(id);
            Views.put(id, view);
        }
        return  view;
    }
    public View getView() {
        return itemView;
    }
}