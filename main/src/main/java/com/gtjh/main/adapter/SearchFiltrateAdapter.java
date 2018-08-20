package com.gtjh.main.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.gtjh.common.adapter.recycler.CommonAdapter;
import com.gtjh.common.adapter.recycler.ViewHolder;
import com.gtjh.common.util.ToastUtils;
import com.gtjh.main.R;
import com.gtjh.main.bean.FilterInfoBean;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by android on 2018/7/18.
 */

public class SearchFiltrateAdapter extends CommonAdapter<FilterInfoBean> {
    private onInfoClickListener onInfoClickListener;
    private int selectorPos=-1;
    private Set<Integer> posSet=new HashSet<>();
    private SearchFiltrateInfoAdapter adapter;
    public SearchFiltrateAdapter(List<FilterInfoBean> datas, Context context) {
        super(datas, context);
    }

    @Override
    protected int getLayoutId(int viewType) {
        return R.layout.item_filtrate_list;
    }

    @Override
    protected void showItemContent(ViewHolder holder, final int position, final FilterInfoBean filterInfoBean) {
        TextView title=holder.findViewById(R.id.tv_title);
        TagFlowLayout flData=holder.findViewById(R.id.fl_data);
        title.setText(filterInfoBean.getLabel());

        final List<FilterInfoBean.ItemsBean> items=filterInfoBean.getItems();
        adapter=new SearchFiltrateInfoAdapter(items,context);
        adapter.setOnInfoClickListener(new SearchFiltrateInfoAdapter.onFInfoClickListener() {
            @Override
            public void onFInfo(int pos, Boolean isCheck) {
                if (onInfoClickListener!=null){
                    onInfoClickListener.onInfo(filterInfoBean,pos,position,isCheck);
                }
            }
        });
        flData.setAdapter(adapter);

    }

    public void setSelectorPos(int selectorPos) {
        this.selectorPos = selectorPos;
        posSet.add(selectorPos);
        adapter.setSelectedList(posSet);
    }

    public void setOnInfoClickListener(SearchFiltrateAdapter.onInfoClickListener onInfoClickListener) {
        this.onInfoClickListener = onInfoClickListener;
    }

    public interface onInfoClickListener{
        void onInfo(FilterInfoBean bean,int pos ,int itemPos,Boolean isCheck);
    }
}
