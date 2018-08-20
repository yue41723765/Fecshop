package com.gtjh.classify.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;

import com.gtjh.classify.R;
import com.gtjh.classify.bean.CustomOptionListBean;
import com.gtjh.common.adapter.recycler.CommonAdapter;
import com.gtjh.common.adapter.recycler.ViewHolder;
import com.gtjh.common.image.ImageLoaderPresenter;

import java.util.List;

/**
 * Created by android on 2018/8/2.
 */

public class ItemCustomOptionAdapter extends CommonAdapter<CustomOptionListBean> {
    private OnItemCustomClickListener onItemCustomClickListener;
    public ItemCustomOptionAdapter(List<CustomOptionListBean> datas, Context context) {
        super(datas, context);
    }

    @Override
    protected int getLayoutId(int viewType) {
        return R.layout.item_option;
    }

    @Override
    protected void showItemContent(ViewHolder holder, final int position, final CustomOptionListBean customOptionListBean) {
        CheckBox checkBox=holder.findViewById(R.id.cb_checked);
        final ImageView imageView=holder.findViewById(R.id.iv_img);
        if (customOptionListBean.getImage()!=null&&!"".equals(customOptionListBean.getImage())){
            imageView.setVisibility(View.VISIBLE);
            checkBox.setVisibility(View.GONE);
            ImageLoaderPresenter.getInstance().loadRound(context, customOptionListBean.getImage(), imageView);

            if (customOptionListBean.getIsChecked()==0){
                imageView.setBackground(context.getResources().getDrawable(R.drawable.shape_options));
                imageView.setEnabled(true);
            }else   if (customOptionListBean.getIsChecked()==1){
                imageView.setEnabled(true);
                imageView.setBackground(context.getResources().getDrawable(R.drawable.shape_options_gray));
            }else   if (customOptionListBean.getIsChecked()==2){
                imageView.setBackground(context.getResources().getDrawable(R.drawable.shape_options_gray));
                imageView.setAlpha(0.4f);
                imageView.setEnabled(false);
            }
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (customOptionListBean.getIsChecked()==0){
                        if (onItemCustomClickListener != null) {
                            onItemCustomClickListener.onItemClick(customOptionListBean.getPos(), position, customOptionListBean.getKey(), false);
                        }
                    }else {
                        if (onItemCustomClickListener != null) {
                            onItemCustomClickListener.onItemClick(customOptionListBean.getPos(), position, customOptionListBean.getKey(), true);
                        }
                    }

                }
            });
        }else {
            checkBox.setVisibility(View.VISIBLE);
            imageView.setVisibility(View.GONE);
            checkBox.setText(customOptionListBean.getVal());
            if (customOptionListBean.getIsChecked()==0) {
                checkBox.setChecked(true);
            } else if (customOptionListBean.getIsChecked()==1) {
                checkBox.setChecked(false);
            } else if (customOptionListBean.getIsChecked()==2) {
                checkBox.setEnabled(false);
                // checkBox.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
                checkBox.setPaintFlags(checkBox.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            }
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                   if (onItemCustomClickListener!=null){
                           onItemCustomClickListener.onItemClick(customOptionListBean.getPos(),position,customOptionListBean.getKey(),isChecked);
                   }
                }
            });
        }
    }

    public void setOnItemCustomClickListener(OnItemCustomClickListener onItemCustomClickListener) {
        this.onItemCustomClickListener = onItemCustomClickListener;
    }

    public interface OnItemCustomClickListener{
        void onItemClick(int position,int pos,String val,Boolean isCheck);
    }
}
