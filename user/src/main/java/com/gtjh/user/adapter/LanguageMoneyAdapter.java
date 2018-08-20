package com.gtjh.user.adapter;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gtjh.common.adapter.recycler.CommonAdapter;
import com.gtjh.common.adapter.recycler.ViewHolder;
import com.gtjh.common.entity.LanguageListBean;
import com.gtjh.common.util.SPUtil;
import com.gtjh.common.view.OnItemClickLinster;
import com.gtjh.user.R;
import com.gtjh.user.event.OnSelectorClickListener;

import java.util.List;
import java.util.Map;

/**
 * Created by android on 2018/7/6.
 */

public class LanguageMoneyAdapter extends CommonAdapter<LanguageListBean> {
    private int selector=-1;
    private String name="";
    private OnSelectorClickListener onSelectorClickListener;
    public LanguageMoneyAdapter(List<LanguageListBean> datas, Context context) {
        super(datas, context);
    }

    @Override
    protected int getLayoutId(int viewType) {
        return R.layout.item_text;
    }

    @Override
    protected void showItemContent(ViewHolder holder, int position, final LanguageListBean string) {
        TextView tv_content = holder.findViewById(R.id.tv_content);
        ImageView img=holder.findViewById(R.id.iv_img);
        tv_content.setText(string.getLanguageName());
        if (selector==-1&& SPUtil.getLanguage(context).equals(string.getCode())){
            img.setVisibility(View.VISIBLE);
        }else if (selector==position){
            img.setVisibility(View.VISIBLE);
            name=string.getCode();
        }else {
            img.setVisibility(View.GONE);
        }

        Log.i("TAG",string.getCode());
        setLinster(new OnItemClickLinster() {
            @Override
            public void onItemClick(int position, View view) {
                selector=position;
                specialUpdate();
            }
        });
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

    public String getName() {
        return name;
    }

    public void setOnSelectorClickListener(OnSelectorClickListener onSelectorClickListener) {
        this.onSelectorClickListener = onSelectorClickListener;
    }
}
