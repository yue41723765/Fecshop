package com.gtjh.common;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.gtjh.common.util.ToolBarHelper;
import com.zhy.autolayout.utils.AutoUtils;

/**
 * Created by android on 2018/6/4.
 */

public abstract class ToolBarActivity extends BaseActivity {
    private ToolBarHelper mToolBarHelper;
    public Toolbar toolbar;
    public TextView tv_center;
    public TextView tv_right;
    public Gson gson=new Gson();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void onCreateCustomToolBar(Toolbar toolbar) {
        //插入toolbar视图的内容的起始点与结束点
        toolbar.setContentInsetsRelative(0, 0);
    }

    @Override
    public void setContentView(int layoutResID) {
        mToolBarHelper = new ToolBarHelper(this, layoutResID);
        toolbar = mToolBarHelper.getToolBar();
        toolbar.setTitle("");
        tv_center = mToolBarHelper.getTvCenter();
        tv_right = mToolBarHelper.getTvRight();

        //返回帧布局视图
        AutoUtils.auto(tv_center);
        setContentView(mToolBarHelper.getContentView());
        setSupportActionBar(toolbar);//把toolbar设置到activity中
        onCreateCustomToolBar(toolbar);
    }

    protected void setRight(Build build) {
        tv_right.setText(build.text);
        tv_right.setTextColor(build.textColor);
        tv_right.setTextSize(TypedValue.COMPLEX_UNIT_PX,build.textSize);
        tv_right.setOnClickListener(build.listener);
       AutoUtils.auto(tv_right);
    }

    protected void setTitle(String content) {
        tv_center.setText(content);
    }

    public static class Build {
        public int textSize;
        private int textColor;
        private String text;
        private View.OnClickListener listener;

        public Build setTextSize(int textSize) {
            this.textSize = textSize;
            return this;
        }

        public Build setTextColor(int textColor) {
            this.textColor = textColor;
            return this;
        }

        public Build setText(String text) {
            this.text = text;
            return this;
        }

        public Build setListener(View.OnClickListener listener) {
            this.listener = listener;
            return this;
        }
    }
    public void back(View view){
        finish();
    }
}
