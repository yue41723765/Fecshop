package com.gtjh.common.image;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.widget.ImageView;

public interface ImageLoader {


    /**
     * Show Image
     *
     * @param imageUrl
     * @param imageView
     */
    void displayImage(Context activity, String imageUrl, ImageView imageView);
    void displayImage(Fragment fragment, String imageUrl, ImageView imageView);
     void loadRound(Context context, String url, ImageView imageView);
    void loadRound(Context context, int resId, ImageView imageView);

    void loadCircle(Context context, String url, ImageView imageView);
    void loadCircle(Context context, int resId, ImageView imageView);
}
