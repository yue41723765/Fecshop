package com.gtjh.common.image;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.widget.ImageView;

public class ImageLoaderPresenter implements ImageLoader {
    //代理对象
    private ImageLoader imageLoader;
    private static ImageLoaderPresenter instance;


    public static ImageLoaderPresenter getInstance() {
        return instance;
    }

    private ImageLoaderPresenter(ImageLoader loader) {
        imageLoader = loader;
    }


    public static void init(ImageLoader loader) {
        if (null == instance) {
            synchronized (ImageLoaderPresenter.class) {
                if (null == instance) {
                    instance = new ImageLoaderPresenter(loader);
                }
            }
        }

    }

    @Override
    public void displayImage(Context context, String imageUrl, ImageView imageView) {
        imageLoader.displayImage(context, imageUrl, imageView);
    }

    @Override
    public void displayImage(Fragment fragment, String imageUrl, ImageView imageView) {
        imageLoader.displayImage(fragment, imageUrl, imageView);
    }


    @Override
    public void loadRound(Context context, String url, ImageView imageView) {
        imageLoader.loadRound(context,url,imageView);
    }

    @Override
    public void loadRound(Context context, int resId, ImageView imageView) {
        imageLoader.loadRound(context,resId,imageView);
    }

    @Override
    public void loadCircle(Context context, String url, ImageView imageView) {
        imageLoader.loadCircle(context,url,imageView);
    }

    @Override
    public void loadCircle(Context context, int resId, ImageView imageView) {
        imageLoader.loadCircle(context,resId,imageView);
    }
}