package com.gtjh.main.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gtjh.common.adapter.CommonAdapter;
import com.gtjh.main.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by android on 2018/7/17.
 */

public class SearchHistoryAdapter extends CommonAdapter<String> {
    private onItemClickListener onItemClickListener;
    private List<String> data=new ArrayList<>();
    public SearchHistoryAdapter(List<String> datas, Context context) {
        super(datas, context);
        Collections.reverse(datas);
        this.data=datas;
    }

    public void setData(List<String> datas) {
        Collections.reverse(datas);
        this.data.clear();
        this.data.addAll(datas);
        notifyDataSetChanged();
    }

    public void addData(List<String> data){
        if (data!=null){
            this.data.addAll(data);
        }
        notifyDataSetChanged();
    }
    @Override
    protected int getLayoutId() {
        return R.layout.item_search;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
       ViewHolder viewHolder=null;
       if (convertView==null){
           convertView= LayoutInflater.from(context).inflate(layoutId, parent,false); //加载布局
           viewHolder = new ViewHolder();
           viewHolder.content=convertView.findViewById(R.id.tv_content);
           viewHolder.all=convertView.findViewById(R.id.ll_all);
           convertView.setTag(viewHolder);
       }else {
           viewHolder = (ViewHolder) convertView.getTag();
       }
       viewHolder.content.setText(list.get(position));
       viewHolder.all.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if (onItemClickListener!=null){
                   onItemClickListener.onItemClick(position,list.get(position));
               }
           }
       });
        return convertView;
    }
    private class ViewHolder{
        TextView content;
        LinearLayout all;
    }

    public void setOnItemClickListener(SearchHistoryAdapter.onItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface onItemClickListener{
        void onItemClick(int pos,String value);
    }
}
