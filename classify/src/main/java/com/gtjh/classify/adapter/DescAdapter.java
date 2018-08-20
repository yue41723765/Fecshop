package com.gtjh.classify.adapter;

import android.content.Context;
import android.widget.ImageView;


import com.gtjh.classify.R;
import com.gtjh.common.adapter.recycler.CommonAdapter;
import com.gtjh.common.adapter.recycler.ViewHolder;
import com.gtjh.common.image.ImageLoaderPresenter;
import com.gtjh.common.view.AutoHeightImageView;

import java.util.List;

/**
 * Created by android on 2018/7/27.
 */

public class DescAdapter extends CommonAdapter<String> {
    public DescAdapter(List<String> datas, Context context) {
        super(datas, context);
    }


    @Override
    protected int getLayoutId(int viewType) {
        return R.layout.item_desc;
    }

    @Override
    protected void showItemContent(ViewHolder holder, int position, String s) {
        AutoHeightImageView imageView=holder.findViewById(R.id.iv_img);
        ImageLoaderPresenter.getInstance().loadRound(context, s, imageView);
    }
}
