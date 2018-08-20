package com.gtjh.main.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.holder.Holder;
import com.gtjh.common.image.ImageLoaderPresenter;
import com.gtjh.common.util.RYLog;
import com.gtjh.main.model.entity.Main;


public class ImageViewHolder<T> implements Holder<Main.Advert.AdvertInfo> {
    private ImageView imageView;
    @Override
    public View createView(Context context) {
        imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        return imageView;
    }

    @Override
    public void UpdateUI(Context context, int position, Main.Advert.AdvertInfo data) {
        RYLog.e(data.imgUrl);
        ImageLoaderPresenter.getInstance().displayImage(context, data.imgUrl, imageView);
    }


}