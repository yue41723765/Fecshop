package com.gtjh.classify.adapter;

import android.content.Context;
import android.widget.TextView;

import com.gtjh.classify.R;
import com.gtjh.classify.bean.FilterInfoListBean;
import com.gtjh.common.adapter.recycler.CommonAdapter;
import com.gtjh.common.adapter.recycler.ViewHolder;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by android on 2018/7/19.
 */

public class FiltrateAdapter extends CommonAdapter<FilterInfoListBean> {
    private onInfoClickListener onInfoClickListener;
    private int selectorPos=-1;
    private Set<Integer> posSet=new HashSet<>();
    private FiltrateInfoAdapter adapter;
    private int clear=0;
    public FiltrateAdapter(List<FilterInfoListBean> datas, Context context) {
        super(datas, context);
    }

    @Override
    protected int getLayoutId(int viewType) {
        return  R.layout.item_filtrate_list;
    }

    @Override
    protected void showItemContent(ViewHolder holder, final int position, final FilterInfoListBean filterInfoListBean) {
        TextView title=holder.findViewById(R.id.tv_title);
        TagFlowLayout flData=holder.findViewById(R.id.fl_data);
        title.setText(filterInfoListBean.getLabel());

        final List<FilterInfoListBean.ItemsBean> items=filterInfoListBean.getItems();
        adapter=new FiltrateInfoAdapter(items,context);
        adapter.setOnInfoClickListener(new FiltrateInfoAdapter.onFInfoClickListener() {
            @Override
            public void onFInfo(int pos, Boolean isCheck) {
                if (onInfoClickListener!=null){
                    onInfoClickListener.onInfo(filterInfoListBean,pos,position,isCheck);
                }
            }
        });
        flData.setAdapter(adapter);
    }

    public void setClear(int clear){
       this.clear=clear;
    }
    public void setOnInfoClickListener(FiltrateAdapter.onInfoClickListener onInfoClickListener) {
        this.onInfoClickListener = onInfoClickListener;
    }

    public interface onInfoClickListener{
        void onInfo(FilterInfoListBean bean,int pos ,int itemPos,Boolean isCheck);
    }
}
