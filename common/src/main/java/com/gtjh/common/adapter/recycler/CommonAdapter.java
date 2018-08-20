package com.gtjh.common.adapter.recycler;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gtjh.common.view.OnItemClickLinster;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by android on 2018/5/25.
 */

public abstract class CommonAdapter<T> extends RecyclerView.Adapter<ViewHolder> {
    private List<T> datas;
    protected Context context;
    private OnItemClickLinster linster;


    public void setLinster(OnItemClickLinster linster) {
        this.linster = linster;
    }

    public CommonAdapter setDatas(List<T> datas) {
        if (this.datas != null)
            this.datas.addAll(datas);
        else
            this.datas = datas;
        return this;
    }

    public void initData(Collection<T> datas) {
        if (this.datas == null) {
            this.datas = new ArrayList<>();
        }
        this.datas.clear();
        this.datas.addAll(datas);
        notifyDataSetChanged();
    }

    public void clearData() {
        this.datas = null;
        notifyDataSetChanged();
    }

    public CommonAdapter(List<T> datas, Context context) {
        this.datas = datas;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(getLayoutId(viewType), parent, false);
        return new ViewHolder(view, viewType);
    }

    protected abstract int getLayoutId(int viewType);

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.getView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (linster != null)
                    linster.onItemClick(position, v);
            }
        });
        showItemContent(holder, position, getItem(position));
    }

    public T getItem(int position) {
        return datas.get(position);
    }

    protected abstract void showItemContent(ViewHolder holder, int position, T t);


    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }

    public void removeItem(int position) {
        datas.remove(position);
        this.notifyDataSetChanged();
    }

}
