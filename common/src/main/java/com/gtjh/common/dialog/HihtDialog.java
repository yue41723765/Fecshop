package com.gtjh.common.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.gtjh.common.R;

import com.gtjh.common.dialog.linster.IDialogView;
import com.gtjh.common.dialog.linster.OnLeftLinster;
import com.gtjh.common.dialog.linster.OnRightLinster;
import com.zhy.autolayout.utils.AutoUtils;

/**
 * Created by Administrator on 2018/1/30.
 * 作者：任洋
 * 功能：
 */
public class HihtDialog extends AlertDialog implements View.OnClickListener, IDialogView {
    private ViewGroup viewGroup;
    private OnLeftLinster leftLinster;
    private OnRightLinster rightLinster;
    private Button btn_left, btn_right;
    private TextView tv_title, tv_content;

    public HihtDialog setLeftLinster(OnLeftLinster leftLinster) {
        this.leftLinster = leftLinster;
        return this;
    }

    public HihtDialog setRightLinster(OnRightLinster rightLinster) {
        this.rightLinster = rightLinster;
        return this;
    }

    protected HihtDialog(Context context) {
        super(context);
    }

    public HihtDialog(Context context, int theme) {
        super(context, theme);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.dialog_hiht, null);
        btn_left = (Button) viewGroup.findViewById(R.id.btn_left);
        btn_left.setOnClickListener(this);
        btn_right = (Button) viewGroup.findViewById(R.id.btn_right);
        btn_right.setOnClickListener(this);
        tv_title = (TextView) viewGroup.findViewById(R.id.tv_title);
        tv_content = (TextView) viewGroup.findViewById(R.id.tv_content);
    }

    public HihtDialog setLeftBtnColor(int color) {
        btn_left.setTextColor(color);
        return this;
    }

    public HihtDialog setRightBtnColor(int color) {
        btn_right.setTextColor(color);
        return this;
    }

    public HihtDialog setTitle(String title) {
        tv_title.setText(title);
        return this;
    }

    public HihtDialog setLeftBtnText(String text) {
        btn_left.setText(text);
        return this;
    }

    public HihtDialog setRightBtnText(String text) {
        btn_right.setText(text);
        return this;
    }

    public HihtDialog seContent(String content) {
        tv_content.setText(content);
        return this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AutoUtils.auto(viewGroup);
        setContentView(viewGroup);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_left) {
            onLeftClick();
        } else if (v.getId() == R.id.btn_right) {
            onRightClick();
        }
    }

    @Override
    public void onLeftClick() {
        if (leftLinster != null)
            leftLinster.onClick(this);
    }

    @Override
    public void onMiddleClick() {

    }

    @Override
    public void onRightClick() {
        if (rightLinster != null)
            rightLinster.onClick(this);
    }
}
