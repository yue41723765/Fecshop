package com.gtjh.common.view;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.gtjh.common.R;
import com.gtjh.common.entity.ResponseData;

import java.util.Timer;

/**
 * Created by android on 2018/8/13.
 */

public class FiniDialog extends Dialog {
    private Handler handler = new Handler();
    public FiniDialog(@NonNull Context context) {
        super(context,R.style.MyDialog);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_fini);
        setCanceledOnTouchOutside(true);

        WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
        WindowManager m=getWindow().getWindowManager();
        Display d = m.getDefaultDisplay(); // 获取屏幕宽、高
        layoutParams.gravity = Gravity.CENTER;
        layoutParams.width =(int) d.getWidth()/3*2;
        layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;

        getWindow().getDecorView().setPadding(0, 0, 0, 0);

        getWindow().setBackgroundDrawableResource(R.drawable.shape_gray_trans);
        getWindow().setAttributes(layoutParams);
    }

    @Override
    public void show() {
        super.show();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
               dismiss();
            }
        }, 3000);
    }
}
