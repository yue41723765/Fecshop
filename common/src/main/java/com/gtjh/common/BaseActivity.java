package com.gtjh.common;


import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;

import com.githang.statusbar.StatusBarCompat;
import com.gtjh.aop.annotation.Init;
import com.gtjh.common.view.IBaseView;
import com.zhy.autolayout.AutoFrameLayout;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;

import butterknife.ButterKnife;


/**
 * Created by android on 2018/5/24.
 */

public abstract class BaseActivity extends AppCompatActivity implements IBaseView {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        StatusBarCompat.setStatusBarColor(this,getResources().getColor(R.color.dialog_bg_color) );
        init(savedInstanceState);
    }

    public abstract void init(Bundle savedInstanceState);

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    private static final String LAYOUT_LINEARLAYOUT = "LinearLayout";
    private static final String LAYOUT_FRAMELAYOUT = "FrameLayout";

    private static final String LAYOUT_RELATIVELAYOUT = "RelativeLayout";

    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        View view = null;
        if (name.equals(LAYOUT_FRAMELAYOUT)) {
            view = new AutoFrameLayout(context, attrs);
        }

        if (name.equals(LAYOUT_LINEARLAYOUT)) {
            view = new AutoLinearLayout(context, attrs);
        }

        if (name.equals(LAYOUT_RELATIVELAYOUT)) {
            view = new AutoRelativeLayout(context, attrs);
        }
        if (view != null) return view;

        return super.onCreateView(name, context, attrs);
    }


    public abstract int getLayoutId();


    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    public void back(View view) {
        finish();
    }

    @Override
    public void showDialog() {

    }

    @Override
    public void hideDialog() {

    }
}
