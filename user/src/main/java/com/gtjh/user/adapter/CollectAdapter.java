package com.gtjh.user.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.gtjh.common.adapter.recycler.CommonAdapter;
import com.gtjh.common.adapter.recycler.ViewHolder;
import com.gtjh.common.image.ImageLoaderPresenter;
import com.gtjh.user.R;
import com.gtjh.user.bean.CollectBean;
import com.gtjh.user.bean.CollectListBean;

import java.util.List;

/**
 * Created by android on 2018/7/16.
 */

public class CollectAdapter extends CommonAdapter<CollectBean.ProductListBean> {
    private onDeleteClickListener onDeleteClickListener;
    private Gson gson=new Gson();
    public CollectAdapter(List<CollectBean.ProductListBean> datas, Context context) {
        super(datas, context);
    }

    @Override
    protected int getLayoutId(int viewType) {
        return R.layout.item_collect;
    }

    @Override
    protected void showItemContent(ViewHolder holder, int position, final CollectBean.ProductListBean collectListBean) {
        TextView title=holder.findViewById(R.id.tv_title);
        TextView content=holder.findViewById(R.id.tv_content);
        ImageView img=holder.findViewById(R.id.iv_img);
        ImageView delete=holder.findViewById(R.id.iv_delete);
        TextView contentS=holder.findViewById(R.id.tv_content_s);
        RelativeLayout all=holder.findViewById(R.id.rl_all);



        title.setText(collectListBean.getName());
        CollectBean.ProductListBean.PriceInfoBean.PriceBean priceBean=collectListBean.getPrice_info().getPrice();
        content.setText(priceBean.getCode()+"  "+priceBean.getSymbol()+" "+collectListBean.getPrice());
        ImageLoaderPresenter.getInstance().loadRound(context, collectListBean.getImgUrl(), img);

        if (collectListBean.getPrice_info().getSpecial_price()!=null){
            CollectBean.ProductListBean.PriceInfoBean.PriceBean spBean=gson.fromJson(gson.toJson(collectListBean.getPrice_info().getSpecial_price()), CollectBean.ProductListBean.PriceInfoBean.PriceBean.class);
            contentS.setText(priceBean.getSymbol()+" "+priceBean.getValue());
            content.setText(priceBean.getCode()+" "+priceBean.getSymbol()+" "+spBean.getValue());
            contentS.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        }else {
            content.setText(priceBean.getCode()+"  "+priceBean.getSymbol()+" "+collectListBean.getPrice());
        }
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onDeleteClickListener!=null){
                    onDeleteClickListener.onDelete(collectListBean.getFavorite_id());
                }
            }
        });
        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onDeleteClickListener!=null){
                    onDeleteClickListener.onItem(collectListBean.getProduct_id());
                }
            }
        });
    }

    public void setOnDeleteClickListener(CollectAdapter.onDeleteClickListener onDeleteClickListener) {
        this.onDeleteClickListener = onDeleteClickListener;
    }

    public interface onDeleteClickListener
    {
        void onDelete(String id);
        void onItem(String id);
    }

}
