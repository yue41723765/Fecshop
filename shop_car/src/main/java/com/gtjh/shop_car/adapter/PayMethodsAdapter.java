package com.gtjh.shop_car.adapter;

import android.content.Context;
import android.os.Handler;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.gtjh.common.adapter.recycler.CommonAdapter;
import com.gtjh.common.adapter.recycler.ViewHolder;
import com.gtjh.shop_car.R;
import com.gtjh.shop_car.bean.MethodsListBean;
import com.gtjh.shop_car.event.OnNameClickListener;

import java.util.List;

/**
 * Created by android on 2018/7/24.
 */

public class PayMethodsAdapter extends CommonAdapter<MethodsListBean> {
    private int pos=-1;
    private onCheckedClickListener onCheckedClickListener;
    public PayMethodsAdapter(List<MethodsListBean> datas, Context context) {
        super(datas, context);
    }

    @Override
    protected int getLayoutId(int viewType) {
        return R.layout.item_methods_pay;
    }

    @Override
    protected void showItemContent(ViewHolder holder, final int position, final MethodsListBean methodsListBean) {
        CheckBox checkBox=holder.findViewById(R.id.cb_check);
        TextView name=holder.findViewById(R.id.tv_name);

        name.setText(methodsListBean.getLabel());



        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    pos=position;
                    if (onCheckedClickListener!=null){
                        onCheckedClickListener.checked(position,methodsListBean.getLabel(),methodsListBean.getMethod());
                    }
                }
                specialUpdate();
            }
        });

        if (methodsListBean.getChecked()!=null&&"true".equals(methodsListBean.getChecked())&&pos==-1){
            checkBox.setChecked(true);
            pos=position;
        }else {
            checkBox.setEnabled(true);
            if (position==pos){
                checkBox.setChecked(true);
            }else {
                checkBox.setChecked(false);
            }
        }
        if (checkBox.isChecked()){
            checkBox.setEnabled(false);
        }else {
            checkBox.setEnabled(true);
        }

    }
    private void specialUpdate() {
        Handler handler = new Handler();
        final Runnable r = new Runnable() {
            public void run() {
               // notifyItemChanged(getItemCount() - 1);
                notifyDataSetChanged();
            }
        };
        handler.post(r);
    }

    public void setOnCheckedClickListener(PayMethodsAdapter.onCheckedClickListener onCheckedClickListener) {
        this.onCheckedClickListener = onCheckedClickListener;
    }

    public interface onCheckedClickListener{
        void checked(int pos,String name,String value);
    }
}
