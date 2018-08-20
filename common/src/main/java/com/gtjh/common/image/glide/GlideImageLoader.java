package com.gtjh.common.image.glide;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.gtjh.common.image.ImageLoader;

/**
 * @author Lance
 * @date 2018/4/8
 */

public class GlideImageLoader implements ImageLoader {
    public GlideImageLoader() {
//        new GlideBuilder().setBitmapPool()
//        Glide.init(context, new GlideBuilder());
    }


    @Override
    public void displayImage(Context context, String imageUrl, ImageView imageView) {
        Glide.with(context).load(imageUrl).into(imageView);
    }

    @Override
    public void displayImage(Fragment fragment, String imageUrl, ImageView imageView) {
        Glide.with(fragment).load(imageUrl).into(imageView);
    }

    @Override
    public void loadRound(Context context, String url, ImageView imageView) {
        Glide.with(context).load(url).transform(new GlideRoundTransform(context,6)).into(imageView);
    }

    @Override
    public void loadRound(Context context, int resId, ImageView imageView) {
        Glide.with(context).load(resId).transform(new GlideRoundTransform(context,6)).into(imageView);
    }

    @Override
    public void loadCircle(Context context, String url, ImageView imageView) {
        Glide.with(context).load(url).transform(new GlideCircleTransform(context)).into(imageView);
    }

    @Override
    public void loadCircle(Context context, int resId, ImageView imageView) {
        Glide.with(context).load(resId).transform(new GlideCircleTransform(context)).into(imageView);
    }
}
