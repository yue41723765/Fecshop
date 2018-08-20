package com.gtjh.shop_car.event;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

/**
 * Created by android on 2018/7/25.
 */

public class RecycleTranslateAnimation  {
    public static void showTranslateAnimation(View view){
        TranslateAnimation showAnim = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 1.0f,
                Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f);
        showAnim.setDuration(500);
        view.startAnimation(showAnim);
        view.setVisibility(View.VISIBLE);
    }

    public static void hideTranslateAnimation(View view){
        TranslateAnimation hideAnim = new TranslateAnimation(Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, -1.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f);
        hideAnim.setDuration(500);
        view.setBackground(new ColorDrawable(0XFFFFFF));
        view.startAnimation(hideAnim);
        view.setVisibility(View.GONE);
    }
}
