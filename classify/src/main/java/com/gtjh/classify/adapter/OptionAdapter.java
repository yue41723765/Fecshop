package com.gtjh.classify.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.gtjh.classify.R;
import com.gtjh.classify.bean.DetailsBean;
import com.gtjh.classify.bean.OptionsListBean;
import com.gtjh.common.adapter.recycler.CommonAdapter;
import com.gtjh.common.adapter.recycler.ViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by android on 2018/7/27.
 */

public class OptionAdapter extends CommonAdapter<DetailsBean.ProductBean.OptionsBean>{
    private ItemOptionAdapter adapter;
    private List<OptionsListBean> listBeans=new ArrayList<>();
    private OnSelectorClickListener onSelectorClickListener;
    public OptionAdapter(List<DetailsBean.ProductBean.OptionsBean> datas, Context context) {
        super(datas, context);
    }

    @Override
    protected int getLayoutId(int viewType) {
        return R.layout.item_condition;
    }

    @Override
    protected void showItemContent(ViewHolder holder, final int position, DetailsBean.ProductBean.OptionsBean optionsBean) {
        TextView title=holder.findViewById(R.id.tv_title);
        RecyclerView recyclerView=holder.findViewById(R.id.rv_data);
        title.setText(optionsBean.getLabel());
        recyclerView.setLayoutManager(new GridLayoutManager(context,4));
        listBeans.clear();
        for (DetailsBean.ProductBean.OptionsBean.ValueBean list:optionsBean.getValue()){
            if (list.getShow_as_img()==null||"".equals(list.getShow_as_img())){
                if (list.get_id()==null){
                    listBeans.add(new OptionsListBean(list.getAttr_val(),"",list.getActive(),""));
                }else {
                    listBeans.add(new OptionsListBean(list.getAttr_val(),list.get_id().get$oid(),list.getActive(),""));
                }
            } else {
                if (list.get_id().get$oid()==null||"".equals(list.get_id().get$oid())){
                    listBeans.add(new OptionsListBean(list.getAttr_val(), "", list.getActive(), list.getShow_as_img()));
                }else {
                    listBeans.add(new OptionsListBean(list.getAttr_val(), list.get_id().get$oid(), list.getActive(), list.getShow_as_img()));
                }

            }
        }
        adapter=new ItemOptionAdapter(listBeans,context);
        recyclerView.setAdapter(adapter);
        adapter.setOnGetIdClickListener(new ItemOptionAdapter.OnGetIdClickListener() {
            @Override
            public void onGetId(int pos, String id) {
                if (onSelectorClickListener!=null){
                    onSelectorClickListener.onSelector(position,pos,id);
                }
            }
        });
    }

    public void setOnSelectorClickListener(OnSelectorClickListener onSelectorClickListener) {
        this.onSelectorClickListener = onSelectorClickListener;
    }

    public interface OnSelectorClickListener{
        void onSelector(int parentPos,int cPos,String id);
    }
}
