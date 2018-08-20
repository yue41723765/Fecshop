package com.gtjh.classify.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.gtjh.classify.R;
import com.gtjh.classify.bean.OptionsListBean;
import com.gtjh.common.adapter.recycler.CommonAdapter;
import com.gtjh.common.adapter.recycler.ViewHolder;
import com.gtjh.common.image.ImageLoaderPresenter;
import com.gtjh.common.image.glide.GlideImageLoader;
import com.gtjh.common.image.glide.GlideRoundTransform;
import com.gtjh.common.view.DeleteLineCheckView;

import java.util.List;

/**
 * Created by android on 2018/7/27.
 */

public class ItemOptionAdapter extends CommonAdapter<OptionsListBean> {
    private OnGetIdClickListener onGetIdClickListener;
    private int selectorPos=-1;
    public ItemOptionAdapter(List<OptionsListBean> datas, Context context) {
        super(datas, context);
    }

    @Override
    protected int getLayoutId(int viewType) {
        return R.layout.item_option;
    }

    @Override
    protected void showItemContent(ViewHolder holder, final int position, final OptionsListBean optionsListBean) {
        CheckBox checkBox=holder.findViewById(R.id.cb_checked);
        //DeleteLineCheckView checkBox=holder.findViewById(R.id.dlc_checked);
        ImageView imageView=holder.findViewById(R.id.iv_img);
        if (optionsListBean.getImg()!=null&&!"".equals(optionsListBean.getImg())){
            Log.i("TAGL","list1"+position);
            imageView.setVisibility(View.VISIBLE);
            checkBox.setVisibility(View.GONE);
            ImageLoaderPresenter.getInstance().loadRound(context, optionsListBean.getImg(), imageView);
            if ("current".equals(optionsListBean.getActive())){
                imageView.setBackground(context.getResources().getDrawable(R.drawable.shape_options));
                imageView.setEnabled(true);
            }else   if ("active".equals(optionsListBean.getActive())){
                imageView.setEnabled(true);
                imageView.setBackground(context.getResources().getDrawable(R.drawable.shape_options_gray));
            }else   if ("noactive".equals(optionsListBean.getActive())){
                imageView.setBackgroundColor(Color.WHITE);
                imageView.setAlpha(0.4f);
                imageView.setEnabled(false);
            }

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onGetIdClickListener!=null){
                        onGetIdClickListener.onGetId(position,optionsListBean.getId());
                    }
                }
            });
        }else {
            Log.i("TAGL", "list2" + position);
            checkBox.setVisibility(View.VISIBLE);
            imageView.setVisibility(View.GONE);
            checkBox.setText(optionsListBean.getValue());
            if ("current".equals(optionsListBean.getActive())) {
                checkBox.setChecked(true);
            } else if ("active".equals(optionsListBean.getActive())) {
                checkBox.setChecked(false);
            } else if ("noactive".equals(optionsListBean.getActive())) {
                checkBox.setEnabled(false);
               // checkBox.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
               checkBox.setPaintFlags(checkBox.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            }
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (onGetIdClickListener != null) {
                        onGetIdClickListener.onGetId(position, optionsListBean.getId());
                    }
                }
            });
        }
    }

    public void setOnGetIdClickListener(OnGetIdClickListener onGetIdClickListener) {
        this.onGetIdClickListener = onGetIdClickListener;
    }

    public interface OnGetIdClickListener{
        void onGetId(int pos,String id);
    }
}
