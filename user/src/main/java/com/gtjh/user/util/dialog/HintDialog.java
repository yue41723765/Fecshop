package com.gtjh.user.util.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.gtjh.user.R;

/**
 * Created by android on 2018/7/16.
 */

public class HintDialog  extends Dialog{
    TextView content;
    TextView left;
    TextView right;
    private OnRightClickListener onRightClickListener;
    public HintDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_hint_message);
        setCanceledOnTouchOutside(true);

        Window window=getWindow();
        WindowManager m=window.getWindowManager();
        WindowManager.LayoutParams lp =window.getAttributes();
        Display d = m.getDefaultDisplay(); // 获取屏幕宽、高
        lp.width =(int) d.getWidth()/3*2;
        lp.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        window.setAttributes(lp);
        window.setGravity(Gravity.CENTER);
        window.setWindowAnimations(R.style.DialogOutAndInStyle);
        initView();
    }

    private void initView() {
        content=findViewById(R.id.tv_content);
        left=findViewById(R.id.tv_left);
        right=findViewById(R.id.tv_right);

        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onRightClickListener!=null){
                    onRightClickListener.onRight();
                }
            }
        });
    }

    public void setTitle(String s){
        content.setText(s);
    }

    public void setOnRightClickListener(OnRightClickListener onRightClickListener) {
        this.onRightClickListener = onRightClickListener;
    }

    public interface OnRightClickListener{
        void onRight();
    }
}
