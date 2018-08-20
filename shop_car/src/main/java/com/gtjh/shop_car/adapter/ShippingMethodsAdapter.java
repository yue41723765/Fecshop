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

import java.util.List;

/**
 * Created by android on 2018/7/24.
 */

public class ShippingMethodsAdapter extends CommonAdapter<MethodsListBean> {
    private onCheckedClickListener onCheckedClickListener;
    private int pos=-1;
    public ShippingMethodsAdapter(List<MethodsListBean> datas, Context context) {
        super(datas, context);
    }

    @Override
    protected int getLayoutId(int viewType) {
        return R.layout.item_methods_shipping;
    }

    @Override
    protected void showItemContent(ViewHolder holder, final int position, final MethodsListBean methodsListBean) {
        TextView name=holder.findViewById(R.id.tv_name);
        TextView content=holder.findViewById(R.id.tv_content);
        CheckBox check=holder.findViewById(R.id.cb_check);




        final String price=methodsListBean.getName()+"\t"+methodsListBean.getSymbol()+methodsListBean.getCost();
        name.setText(methodsListBean.getLabel());
        content.setText(price);

        check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    pos=position;
                    if (onCheckedClickListener!=null){
                        onCheckedClickListener.onCheck(position,methodsListBean.getLabel(),methodsListBean.getMethod(),price);
                    }
                }
                specialUpdate();
            }
        });

        if (methodsListBean.getChecked()!=null&&"true".equals(methodsListBean.getChecked())&&pos==-1){
            check.setChecked(true);
            pos=position;
        }else {
            check.setEnabled(true);
            if (position==pos){
                check.setChecked(true);
            }else {
                check.setChecked(false);
            }
        }
        if (check.isChecked()){
            check.setEnabled(false);
        }else {
            check.setEnabled(true);
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

    public void setOnCheckedClickListener(ShippingMethodsAdapter.onCheckedClickListener onCheckedClickListener) {
        this.onCheckedClickListener = onCheckedClickListener;
    }

    public interface onCheckedClickListener{
        void onCheck(int pos,String name,String value,String price);
    }
}
