package com.gtjh.main.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.gtjh.common.adapter.recycler.CommonAdapter;
import com.gtjh.common.adapter.recycler.ViewHolder;
import com.gtjh.common.image.ImageLoaderPresenter;
import com.gtjh.main.R;
import com.gtjh.main.model.entity.Main;

import java.util.List;

/**
 * Created by android on 2018/7/4.
 */

public class AdvertAdapter extends CommonAdapter<Main.Advert.AdvertInfo> {
    public AdvertAdapter(List<Main.Advert.AdvertInfo> datas, Context context) {
        super(datas, context);
    }

    @Override
    protected int getLayoutId(int viewType) {
        return R.layout.item_advert;
    }

    @Override
    protected void showItemContent(ViewHolder holder, int position, Main.Advert.AdvertInfo advertInfo) {
        ImageView iv_img = holder.findViewById(R.id.iv_img);
        TextView tv_title = holder.findViewById(R.id.tv_title);
        tv_title.setText(advertInfo.title);
        ImageLoaderPresenter.getInstance().loadRound(context, advertInfo.imgUrl, iv_img);
    }
}
