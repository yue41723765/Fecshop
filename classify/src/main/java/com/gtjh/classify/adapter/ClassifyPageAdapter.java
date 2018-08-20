package com.gtjh.classify.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gtjh.classify.R;
import com.gtjh.classify.bean.ClassifyPageListBean;
import com.gtjh.common.adapter.recycler.CommonAdapter;
import com.gtjh.common.adapter.recycler.ViewHolder;
import com.gtjh.common.image.ImageLoaderPresenter;

import java.util.List;

/**
 * Created by android on 2018/7/20.
 */

public class ClassifyPageAdapter extends CommonAdapter<ClassifyPageListBean> {
    private onItemClickListener onItemClickListener;
    public ClassifyPageAdapter(List<ClassifyPageListBean> datas, Context context) {
        super(datas, context);
    }

    @Override
    protected int getLayoutId(int viewType) {
        return R.layout.item_classify;
    }

    @Override
    protected void showItemContent(ViewHolder holder, int position, ClassifyPageListBean classifyPageListBean) {

        ImageView img=holder.findViewById(R.id.iv_img);
        ImageView imgT=holder.findViewById(R.id.iv_img_t);
        RelativeLayout rlOne=holder.findViewById(R.id.rl_one);
        RelativeLayout rlTwo=holder.findViewById(R.id.rl_two);
        TextView title=holder.findViewById(R.id.tv_title);
        TextView titleT=holder.findViewById(R.id.tv_title_t);
        TextView content=holder.findViewById(R.id.tv_content);
        TextView contentT=holder.findViewById(R.id.tv_content_t);
        TextView contentS=holder.findViewById(R.id.tv_content_s);
        TextView contentSP=holder.findViewById(R.id.tv_content_sp);

        final ClassifyPageListBean.OneBean oneBean=classifyPageListBean.getOne();
        final ClassifyPageListBean.TwoBean twoBean=classifyPageListBean.getTwo();
        ImageLoaderPresenter.getInstance().loadRound(context, oneBean.getImage(), img);
        title.setText(oneBean.getName());


        if (oneBean.getSpecial_price().getValue()!=null){
            contentS.setText(oneBean.getPrice().getSymbol()+" "+oneBean.getPrice().getValue());
            content.setText(oneBean.getPrice().getCode()+" "+oneBean.getPrice().getSymbol()+" "+oneBean.getSpecial_price().getValue());
            contentS.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        }else {
            content.setText(oneBean.getPrice().getCode()+"  "+oneBean.getPrice().getSymbol()+" "+oneBean.getPrice().getValue());
        }
        if (twoBean.getProduct_id()!=null){
            rlTwo.setVisibility(View.VISIBLE);
            rlTwo.setEnabled(true);
            ImageLoaderPresenter.getInstance().loadRound(context, twoBean.getImage(), imgT);
            titleT.setText(twoBean.getName());
            contentT.setText(twoBean.getPrice().getCode()+" "+twoBean.getPrice().getSymbol()+" "+twoBean.getPrice().getValue());
            if (twoBean.getSpecial_price().getValue()!=null){
                contentSP.setText(twoBean.getPrice().getSymbol()+" "+twoBean.getPrice().getValue());
                contentT.setText(twoBean.getPrice().getCode()+" "+twoBean.getPrice().getSymbol()+" "+twoBean.getSpecial_price().getValue());
                contentSP.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            }else {
                contentT.setText(twoBean.getPrice().getCode()+" "+twoBean.getPrice().getSymbol()+" "+twoBean.getPrice().getValue());
            }
        }else {
            rlTwo.setVisibility(View.INVISIBLE);
            rlTwo.setEnabled(false);
        }

        //左右的监听
        rlOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener!=null){
                    onItemClickListener.onItem(oneBean.getProduct_id());
                }
            }
        });
        rlTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener!=null){
                    onItemClickListener.onItem(twoBean.getProduct_id());
                }
            }
        });
    }
    public void setOnItemClickListener(onItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface onItemClickListener{
        void onItem(String productId);
    }
}
