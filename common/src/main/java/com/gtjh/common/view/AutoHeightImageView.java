package com.gtjh.common.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by android on 2018/7/31.
 */

public class AutoHeightImageView extends AppCompatImageView {

    public AutoHeightImageView(Context context) {
        super(context);
    }

    public AutoHeightImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AutoHeightImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Drawable drawable = getDrawable();
        if(drawable != null){
            int width = drawable.getMinimumWidth();
            int height = drawable.getMinimumHeight();
            float scale = (float)height/width;

            int widthMeasure = MeasureSpec.getSize(widthMeasureSpec);
            int heightMeasure = (int)(widthMeasure*scale);

            heightMeasureSpec =  MeasureSpec.makeMeasureSpec(heightMeasure, MeasureSpec.EXACTLY);
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
