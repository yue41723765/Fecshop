package com.gtjh.user.adapter;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gtjh.common.adapter.recycler.CommonAdapter;
import com.gtjh.common.adapter.recycler.ViewHolder;
import com.gtjh.common.entity.CurrencyListBean;
import com.gtjh.common.util.SPUtil;
import com.gtjh.common.view.OnItemClickLinster;
import com.gtjh.user.R;
import com.gtjh.user.event.OnSelectorClickListener;

import java.util.List;

/**
 * Created by android on 2018/8/9.
 */

public class CurrencyAdapter extends CommonAdapter<CurrencyListBean> {
    private int selector=-1;
    private OnSelectorClickListener onSelectorClickListener;
    private String name;
    public CurrencyAdapter(List<CurrencyListBean> datas, Context context) {
        super(datas, context);
    }

    @Override
    protected int getLayoutId(int viewType) {
        return R.layout.item_text;
    }

    @Override
    protected void showItemContent(ViewHolder holder, int position, final CurrencyListBean currencyListBean) {
        TextView tv_content = holder.findViewById(R.id.tv_content);
        ImageView img=holder.findViewById(R.id.iv_img);
        tv_content.setText(currencyListBean.getSymbol()+" "+currencyListBean.getCode());
        if (selector==-1&& SPUtil.getCurrency(context).equals(currencyListBean.getCode())){
            img.setVisibility(View.VISIBLE);
        }else if (selector==position){
            img.setVisibility(View.VISIBLE);
            name=currencyListBean.getCode();
        }else {
            img.setVisibility(View.GONE);
        }
        Log.i("TAG",currencyListBean.getCode());
        setLinster(new OnItemClickLinster() {
            @Override
            public void onItemClick(int position, View view) {
                selector=position;
                specialUpdate();
            }
        });
    }

    public String getName() {
        return name;
    }

    private void specialUpdate() {
        Handler handler = new Handler();
        final Runnable r = new Runnable() {
            public void run() {
                //单个条目更新
                // notifyItemChanged(getItemCount() - 1);
                //刷屏
                notifyDataSetChanged();
            }
        };
        handler.post(r);
    }

    public void setOnSelectorClickListener(OnSelectorClickListener onSelectorClickListener) {
        this.onSelectorClickListener = onSelectorClickListener;
    }
}
