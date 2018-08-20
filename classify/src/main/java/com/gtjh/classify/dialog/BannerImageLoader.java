package com.gtjh.classify.dialog;

import android.content.Context;
import android.widget.ImageView;

import com.gtjh.classify.R;
import com.gtjh.common.image.ImageLoaderPresenter;
import com.gtjh.common.image.glide.GlideImageLoader;
import com.gtjh.common.util.GlideLoadUtils;
import com.youth.banner.loader.ImageLoader;

import okhttp3.internal.Util;

/**
 * Created by android on 2018/7/27.
 */

public class BannerImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        GlideLoadUtils.getInstance().glideLoad(context,path.toString(),imageView, R.drawable.ic_load);
        //ImageLoaderPresenter.getInstance().loadRound(context, path.toString(), imageView);
    }

}
