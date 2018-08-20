package com.gtjh.user.util.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.gtjh.common.entity.Price;
import com.gtjh.user.R;
import com.gtjh.user.util.WheelView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by android on 2018/7/12.
 */

public class PickerDialog extends Dialog {
    private TextView change;
    private ImageView close;
    private WheelView wheelView;
    private onChangeClickListener onChangeClickListener;
    private String key="";
    private String value="";
    private Map<String,Object> data=new HashMap<>();
    private ArrayList<String> keys=new ArrayList<>();
    private ArrayList<String> values=new ArrayList<>();
    public void setData(Map<String,Object> data){
        this.data=data;
        initWheel();
    }



    public PickerDialog(@NonNull Context context) {
        super(context, R.style.PickerDialog);
        setContentView(R.layout.dialog_picker);
        setCanceledOnTouchOutside(true);

        WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
        layoutParams.gravity = Gravity.BOTTOM;
        layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
        layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;

        getWindow().getDecorView().setPadding(0, 0, 0, 0);

        getWindow().setAttributes(layoutParams);
        getWindow().setWindowAnimations(R.style.DialogOutAndInStyle);
        initView();

    }

    private void initWheel() {

        Iterator iterator=data.entrySet().iterator();
        int i=0;
        while (iterator.hasNext()){
            Map.Entry<String, String> entry= (Map.Entry<String, String>) iterator.next();
            keys.add(i,entry.getKey());
            values.add(i,entry.getValue());
            i++;
        }

        wheelView.lists(values).fontSize(40).showCount(5).selectTip("").select(0).listener(new WheelView.OnWheelViewItemSelectListener() {
            @Override
            public void onItemSelect(int index) {
                Log.d("cc", "current select:" + wheelView.getSelectItem() + " index :" + index + ",result=" + keys.get(index)+":"+values.get(index));
                key=keys.get(index);
                value=values.get(index);
            }
        }).build();
    }

    private void initView() {
        change=findViewById(R.id.tv_change);
        close=findViewById(R.id.iv_close);
        wheelView=findViewById(R.id.wv_wheel);

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onChangeClickListener!=null){
                    onChangeClickListener.onChange(key,value);
                }
                dismiss();
            }
        });
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    public void setOnChangeClickListener(PickerDialog.onChangeClickListener onChangeClickListener) {
        this.onChangeClickListener = onChangeClickListener;
    }

    public interface onChangeClickListener{
        void onChange(String key,String value);
    }
}
